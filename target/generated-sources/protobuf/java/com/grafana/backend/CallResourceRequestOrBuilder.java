// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: backend.proto
// Protobuf Java Version: 4.28.3

package com.grafana.backend;

public interface CallResourceRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:pluginv2.CallResourceRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.pluginv2.PluginContext pluginContext = 1;</code>
   * @return Whether the pluginContext field is set.
   */
  boolean hasPluginContext();
  /**
   * <code>.pluginv2.PluginContext pluginContext = 1;</code>
   * @return The pluginContext.
   */
  com.grafana.backend.PluginContext getPluginContext();
  /**
   * <code>.pluginv2.PluginContext pluginContext = 1;</code>
   */
  com.grafana.backend.PluginContextOrBuilder getPluginContextOrBuilder();

  /**
   * <code>string path = 2;</code>
   * @return The path.
   */
  java.lang.String getPath();
  /**
   * <code>string path = 2;</code>
   * @return The bytes for path.
   */
  com.google.protobuf.ByteString
      getPathBytes();

  /**
   * <code>string method = 3;</code>
   * @return The method.
   */
  java.lang.String getMethod();
  /**
   * <code>string method = 3;</code>
   * @return The bytes for method.
   */
  com.google.protobuf.ByteString
      getMethodBytes();

  /**
   * <code>string url = 4;</code>
   * @return The url.
   */
  java.lang.String getUrl();
  /**
   * <code>string url = 4;</code>
   * @return The bytes for url.
   */
  com.google.protobuf.ByteString
      getUrlBytes();

  /**
   * <code>map&lt;string, .pluginv2.StringList&gt; headers = 5;</code>
   */
  int getHeadersCount();
  /**
   * <code>map&lt;string, .pluginv2.StringList&gt; headers = 5;</code>
   */
  boolean containsHeaders(
      java.lang.String key);
  /**
   * Use {@link #getHeadersMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, com.grafana.backend.StringList>
  getHeaders();
  /**
   * <code>map&lt;string, .pluginv2.StringList&gt; headers = 5;</code>
   */
  java.util.Map<java.lang.String, com.grafana.backend.StringList>
  getHeadersMap();
  /**
   * <code>map&lt;string, .pluginv2.StringList&gt; headers = 5;</code>
   */
  /* nullable */
com.grafana.backend.StringList getHeadersOrDefault(
      java.lang.String key,
      /* nullable */
com.grafana.backend.StringList defaultValue);
  /**
   * <code>map&lt;string, .pluginv2.StringList&gt; headers = 5;</code>
   */
  com.grafana.backend.StringList getHeadersOrThrow(
      java.lang.String key);

  /**
   * <code>bytes body = 6;</code>
   * @return The body.
   */
  com.google.protobuf.ByteString getBody();
}
