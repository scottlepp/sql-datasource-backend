// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: backend.proto
// Protobuf Java Version: 4.28.3

package com.grafana.backend;

public interface PublishStreamResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:pluginv2.PublishStreamResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * status of publish response.
   * </pre>
   *
   * <code>.pluginv2.PublishStreamResponse.Status status = 1;</code>
   * @return The enum numeric value on the wire for status.
   */
  int getStatusValue();
  /**
   * <pre>
   * status of publish response.
   * </pre>
   *
   * <code>.pluginv2.PublishStreamResponse.Status status = 1;</code>
   * @return The status.
   */
  com.grafana.backend.PublishStreamResponse.Status getStatus();

  /**
   * <pre>
   * JSON-encoded data to publish into a channel. This can be
   * unmodified data from a PublishRequest or any modified data.
   * If empty data returned here then Grafana won't publish data
   * to a channel itself but will return a successful result to a
   * client (supposing plugin published data to a channel itself).
   * </pre>
   *
   * <code>bytes data = 2;</code>
   * @return The data.
   */
  com.google.protobuf.ByteString getData();
}
