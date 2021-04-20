// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: kikimr/public/api/grpc/draft/ydb_datastreams_v1.proto

package tech.ydb.datastreams.v1;

public final class YdbDatastreamsV1 {
  private YdbDatastreamsV1() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n5kikimr/public/api/grpc/draft/ydb_datas" +
      "treams_v1.proto\022\022Ydb.DataStreams.V1\0320kik" +
      "imr/public/api/protos/draft/datastreams." +
      "proto2\345\032\n\022DataStreamsService\022a\n\014CreateSt" +
      "ream\022\'.Ydb.DataStreams.V1.CreateStreamRe" +
      "quest\032(.Ydb.DataStreams.V1.CreateStreamR" +
      "esponse\022^\n\013ListStreams\022&.Ydb.DataStreams" +
      ".V1.ListStreamsRequest\032\'.Ydb.DataStreams" +
      ".V1.ListStreamsResponse\022a\n\014DeleteStream\022" +
      "\'.Ydb.DataStreams.V1.DeleteStreamRequest",
      "\032(.Ydb.DataStreams.V1.DeleteStreamRespon" +
      "se\022g\n\016DescribeStream\022).Ydb.DataStreams.V" +
      "1.DescribeStreamRequest\032*.Ydb.DataStream" +
      "s.V1.DescribeStreamResponse\022[\n\nListShard" +
      "s\022%.Ydb.DataStreams.V1.ListShardsRequest" +
      "\032&.Ydb.DataStreams.V1.ListShardsResponse" +
      "\022d\n\rSetWriteQuota\022(.Ydb.DataStreams.V1.S" +
      "etWriteQuotaRequest\032).Ydb.DataStreams.V1" +
      ".SetWriteQuotaResponse\022a\n\014UpdateStream\022\'" +
      ".Ydb.DataStreams.V1.UpdateStreamRequest\032",
      "(.Ydb.DataStreams.V1.UpdateStreamRespons" +
      "e\022X\n\tPutRecord\022$.Ydb.DataStreams.V1.PutR" +
      "ecordRequest\032%.Ydb.DataStreams.V1.PutRec" +
      "ordResponse\022[\n\nPutRecords\022%.Ydb.DataStre" +
      "ams.V1.PutRecordsRequest\032&.Ydb.DataStrea" +
      "ms.V1.PutRecordsResponse\022[\n\nGetRecords\022%" +
      ".Ydb.DataStreams.V1.GetRecordsRequest\032&." +
      "Ydb.DataStreams.V1.GetRecordsResponse\022m\n" +
      "\020GetShardIterator\022+.Ydb.DataStreams.V1.G" +
      "etShardIteratorRequest\032,.Ydb.DataStreams",
      ".V1.GetShardIteratorResponse\022o\n\020Subscrib" +
      "eToShard\022+.Ydb.DataStreams.V1.SubscribeT" +
      "oShardRequest\032,.Ydb.DataStreams.V1.Subsc" +
      "ribeToShardResponse0\001\022g\n\016DescribeLimits\022" +
      ").Ydb.DataStreams.V1.DescribeLimitsReque" +
      "st\032*.Ydb.DataStreams.V1.DescribeLimitsRe" +
      "sponse\022|\n\025DescribeStreamSummary\0220.Ydb.Da" +
      "taStreams.V1.DescribeStreamSummaryReques" +
      "t\0321.Ydb.DataStreams.V1.DescribeStreamSum" +
      "maryResponse\022\224\001\n\035DecreaseStreamRetention",
      "Period\0228.Ydb.DataStreams.V1.DecreaseStre" +
      "amRetentionPeriodRequest\0329.Ydb.DataStrea" +
      "ms.V1.DecreaseStreamRetentionPeriodRespo" +
      "nse\022\224\001\n\035IncreaseStreamRetentionPeriod\0228." +
      "Ydb.DataStreams.V1.IncreaseStreamRetenti" +
      "onPeriodRequest\0329.Ydb.DataStreams.V1.Inc" +
      "reaseStreamRetentionPeriodResponse\022m\n\020Up" +
      "dateShardCount\022+.Ydb.DataStreams.V1.Upda" +
      "teShardCountRequest\032,.Ydb.DataStreams.V1" +
      ".UpdateShardCountResponse\022\177\n\026RegisterStr",
      "eamConsumer\0221.Ydb.DataStreams.V1.Registe" +
      "rStreamConsumerRequest\0322.Ydb.DataStreams" +
      ".V1.RegisterStreamConsumerResponse\022\205\001\n\030D" +
      "eregisterStreamConsumer\0223.Ydb.DataStream" +
      "s.V1.DeregisterStreamConsumerRequest\0324.Y" +
      "db.DataStreams.V1.DeregisterStreamConsum" +
      "erResponse\022\177\n\026DescribeStreamConsumer\0221.Y" +
      "db.DataStreams.V1.DescribeStreamConsumer" +
      "Request\0322.Ydb.DataStreams.V1.DescribeStr" +
      "eamConsumerResponse\022v\n\023ListStreamConsume",
      "rs\022..Ydb.DataStreams.V1.ListStreamConsum" +
      "ersRequest\032/.Ydb.DataStreams.V1.ListStre" +
      "amConsumersResponse\022j\n\017AddTagsToStream\022*" +
      ".Ydb.DataStreams.V1.AddTagsToStreamReque" +
      "st\032+.Ydb.DataStreams.V1.AddTagsToStreamR" +
      "esponse\022\210\001\n\031DisableEnhancedMonitoring\0224." +
      "Ydb.DataStreams.V1.DisableEnhancedMonito" +
      "ringRequest\0325.Ydb.DataStreams.V1.Disable" +
      "EnhancedMonitoringResponse\022\205\001\n\030EnableEnh" +
      "ancedMonitoring\0223.Ydb.DataStreams.V1.Ena",
      "bleEnhancedMonitoringRequest\0324.Ydb.DataS" +
      "treams.V1.EnableEnhancedMonitoringRespon" +
      "se\022p\n\021ListTagsForStream\022,.Ydb.DataStream" +
      "s.V1.ListTagsForStreamRequest\032-.Ydb.Data" +
      "Streams.V1.ListTagsForStreamResponse\022^\n\013" +
      "MergeShards\022&.Ydb.DataStreams.V1.MergeSh" +
      "ardsRequest\032\'.Ydb.DataStreams.V1.MergeSh" +
      "ardsResponse\022y\n\024RemoveTagsFromStream\022/.Y" +
      "db.DataStreams.V1.RemoveTagsFromStreamRe" +
      "quest\0320.Ydb.DataStreams.V1.RemoveTagsFro",
      "mStreamResponse\022[\n\nSplitShard\022%.Ydb.Data" +
      "Streams.V1.SplitShardRequest\032&.Ydb.DataS" +
      "treams.V1.SplitShardResponse\022|\n\025StartStr" +
      "eamEncryption\0220.Ydb.DataStreams.V1.Start" +
      "StreamEncryptionRequest\0321.Ydb.DataStream" +
      "s.V1.StartStreamEncryptionResponse\022y\n\024St" +
      "opStreamEncryption\022/.Ydb.DataStreams.V1." +
      "StopStreamEncryptionRequest\0320.Ydb.DataSt" +
      "reams.V1.StopStreamEncryptionResponseB\"\n" +
      "\035tech.ydb.datastreams.v1\370\001\001b\006proto",
      "3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          tech.ydb.datastreams.v1.Datastreams.getDescriptor(),
        }, assigner);
    tech.ydb.datastreams.v1.Datastreams.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
