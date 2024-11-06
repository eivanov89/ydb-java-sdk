package tech.ydb.core.impl.pool;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.google.common.annotations.VisibleForTesting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Nikolay Perfilov
 */
public class GrpcChannelPool {

    private class EndpointChannels {
        private final List<GrpcChannel> channelList;
        private final AtomicInteger roundRobinIndex = new AtomicInteger(0);

        // TODO: make it configurable
        private final int channelCountPerEndpoint = 2;

        EndpointChannels(EndpointRecord endpoint) {
            this.channelList = new CopyOnWriteArrayList<>();

            for (int i = 0; i < channelCountPerEndpoint; i++) {
                channelList.add(new GrpcChannel(endpoint, channelFactory));
            }
        }

        public GrpcChannel getNextChannel() {
            int index = roundRobinIndex.getAndUpdate(i -> (i + 1) % channelList.size());
            return channelList.get(index);
        }
    }

    private static final Logger logger = LoggerFactory.getLogger(GrpcChannelPool.class);

    private final Map<String, EndpointChannels> channels = new ConcurrentHashMap<>();
    private final ManagedChannelFactory channelFactory;
    private final ScheduledExecutorService executor;

    public GrpcChannelPool(ManagedChannelFactory channelFactory, ScheduledExecutorService executor) {
        this.channelFactory = channelFactory;
        this.executor = executor;
    }

    public GrpcChannel getChannel(EndpointRecord endpoint) {
        // Workaround for https://bugs.openjdk.java.net/browse/JDK-8161372 to prevent unnecessary locks in Java 8
        // Was fixed in Java 9+

        EndpointChannels endpointChannels = channels.computeIfAbsent(endpoint.getHostAndPort(), key -> {
            logger.debug("Channels for " + endpoint.getHostAndPort() + " were not found in pool, creating...");
            return new EndpointChannels(endpoint);
        });

        return endpointChannels.getNextChannel();
    }

    private CompletableFuture<Boolean> shutdownChannels(Collection<GrpcChannel> channelsToShutdown) {
        if (channelsToShutdown.isEmpty()) {
            return CompletableFuture.completedFuture(Boolean.TRUE);
        }

        logger.debug("shutdown {} channels", channelsToShutdown.size());
        return CompletableFuture.supplyAsync(() -> {
            int closed = 0;
            for (GrpcChannel channel : channelsToShutdown) {
                if (Thread.currentThread().isInterrupted()) {
                    return false;
                }
                if (channel.shutdown()) {
                    closed++;
                }
            }
            return closed == channelsToShutdown.size();
        }, executor);
    }

    public CompletableFuture<Boolean> removeChannels(Collection<EndpointRecord> endpointsToRemove) {
        if (endpointsToRemove == null || endpointsToRemove.isEmpty()) {
            return CompletableFuture.completedFuture(Boolean.TRUE);
        }

        logger.debug("removing {} endpoints from pool: {}", endpointsToRemove.size(), endpointsToRemove);

        List<GrpcChannel> channelsToShutdown = endpointsToRemove.stream()
                .map(EndpointRecord::getHostAndPort)
                .map(channels::remove)
                .filter(Objects::nonNull)
                .flatMap(endpointChannels -> endpointChannels.channelList.stream())
                .collect(Collectors.toList());

        return shutdownChannels(channelsToShutdown);
    }

    public CompletableFuture<Boolean> shutdown() {
        logger.debug("Initiating gRPC pool shutdown with {} endpoints...", channels.size());

        // Collect all GrpcChannel instances from each EndpointChannels
        List<GrpcChannel> channelsToShutdown = channels.values().stream()
                .flatMap(endpointChannels -> endpointChannels.channelList.stream()) // Flatten all GrpcChannel instances
                .collect(Collectors.toList());

        // Initiate shutdown for all collected channels
        return shutdownChannels(channelsToShutdown).whenComplete((res, th) -> {
            if (th != null) {
                logger.warn("An error occurred during the gRPC pool shutdown", th);
            } else if (res != null && res) {
                logger.debug("gRPC pool was shut down successfully");
            } else {
                logger.warn("gRPC pool was not shut down properly");
            }
        });
    }

    // TODO: not sure, here I try to return only single channel for each endpoint
    // to keep tests green. I.e. "backward compatibility"
    @VisibleForTesting
    Map<String, GrpcChannel> getChannels() {
        return channels.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().channelList.get(0)
            ));
    }
}
