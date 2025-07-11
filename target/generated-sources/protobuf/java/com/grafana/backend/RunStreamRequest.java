// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: backend.proto
// Protobuf Java Version: 4.28.3

package com.grafana.backend;

/**
 * Protobuf type {@code pluginv2.RunStreamRequest}
 */
public final class RunStreamRequest extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:pluginv2.RunStreamRequest)
    RunStreamRequestOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 28,
      /* patch= */ 3,
      /* suffix= */ "",
      RunStreamRequest.class.getName());
  }
  // Use RunStreamRequest.newBuilder() to construct.
  private RunStreamRequest(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private RunStreamRequest() {
    path_ = "";
    data_ = com.google.protobuf.ByteString.EMPTY;
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.grafana.backend.BackendProto.internal_static_pluginv2_RunStreamRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.grafana.backend.BackendProto.internal_static_pluginv2_RunStreamRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.grafana.backend.RunStreamRequest.class, com.grafana.backend.RunStreamRequest.Builder.class);
  }

  private int bitField0_;
  public static final int PLUGINCONTEXT_FIELD_NUMBER = 1;
  private com.grafana.backend.PluginContext pluginContext_;
  /**
   * <code>.pluginv2.PluginContext pluginContext = 1;</code>
   * @return Whether the pluginContext field is set.
   */
  @java.lang.Override
  public boolean hasPluginContext() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.pluginv2.PluginContext pluginContext = 1;</code>
   * @return The pluginContext.
   */
  @java.lang.Override
  public com.grafana.backend.PluginContext getPluginContext() {
    return pluginContext_ == null ? com.grafana.backend.PluginContext.getDefaultInstance() : pluginContext_;
  }
  /**
   * <code>.pluginv2.PluginContext pluginContext = 1;</code>
   */
  @java.lang.Override
  public com.grafana.backend.PluginContextOrBuilder getPluginContextOrBuilder() {
    return pluginContext_ == null ? com.grafana.backend.PluginContext.getDefaultInstance() : pluginContext_;
  }

  public static final int PATH_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object path_ = "";
  /**
   * <pre>
   * path part of a channel.
   * </pre>
   *
   * <code>string path = 2;</code>
   * @return The path.
   */
  @java.lang.Override
  public java.lang.String getPath() {
    java.lang.Object ref = path_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      path_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * path part of a channel.
   * </pre>
   *
   * <code>string path = 2;</code>
   * @return The bytes for path.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getPathBytes() {
    java.lang.Object ref = path_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      path_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DATA_FIELD_NUMBER = 3;
  private com.google.protobuf.ByteString data_ = com.google.protobuf.ByteString.EMPTY;
  /**
   * <pre>
   * optional raw data. May be used as an extra payload supplied upon subscription.
   * For example, can contain JSON query object.
   * </pre>
   *
   * <code>bytes data = 3;</code>
   * @return The data.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getData() {
    return data_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(1, getPluginContext());
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(path_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 2, path_);
    }
    if (!data_.isEmpty()) {
      output.writeBytes(3, data_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getPluginContext());
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(path_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(2, path_);
    }
    if (!data_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(3, data_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.grafana.backend.RunStreamRequest)) {
      return super.equals(obj);
    }
    com.grafana.backend.RunStreamRequest other = (com.grafana.backend.RunStreamRequest) obj;

    if (hasPluginContext() != other.hasPluginContext()) return false;
    if (hasPluginContext()) {
      if (!getPluginContext()
          .equals(other.getPluginContext())) return false;
    }
    if (!getPath()
        .equals(other.getPath())) return false;
    if (!getData()
        .equals(other.getData())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasPluginContext()) {
      hash = (37 * hash) + PLUGINCONTEXT_FIELD_NUMBER;
      hash = (53 * hash) + getPluginContext().hashCode();
    }
    hash = (37 * hash) + PATH_FIELD_NUMBER;
    hash = (53 * hash) + getPath().hashCode();
    hash = (37 * hash) + DATA_FIELD_NUMBER;
    hash = (53 * hash) + getData().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.grafana.backend.RunStreamRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.grafana.backend.RunStreamRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.grafana.backend.RunStreamRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.grafana.backend.RunStreamRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.grafana.backend.RunStreamRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.grafana.backend.RunStreamRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.grafana.backend.RunStreamRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.grafana.backend.RunStreamRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.grafana.backend.RunStreamRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.grafana.backend.RunStreamRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.grafana.backend.RunStreamRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.grafana.backend.RunStreamRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.grafana.backend.RunStreamRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code pluginv2.RunStreamRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:pluginv2.RunStreamRequest)
      com.grafana.backend.RunStreamRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.grafana.backend.BackendProto.internal_static_pluginv2_RunStreamRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.grafana.backend.BackendProto.internal_static_pluginv2_RunStreamRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.grafana.backend.RunStreamRequest.class, com.grafana.backend.RunStreamRequest.Builder.class);
    }

    // Construct using com.grafana.backend.RunStreamRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage
              .alwaysUseFieldBuilders) {
        getPluginContextFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      pluginContext_ = null;
      if (pluginContextBuilder_ != null) {
        pluginContextBuilder_.dispose();
        pluginContextBuilder_ = null;
      }
      path_ = "";
      data_ = com.google.protobuf.ByteString.EMPTY;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.grafana.backend.BackendProto.internal_static_pluginv2_RunStreamRequest_descriptor;
    }

    @java.lang.Override
    public com.grafana.backend.RunStreamRequest getDefaultInstanceForType() {
      return com.grafana.backend.RunStreamRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.grafana.backend.RunStreamRequest build() {
      com.grafana.backend.RunStreamRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.grafana.backend.RunStreamRequest buildPartial() {
      com.grafana.backend.RunStreamRequest result = new com.grafana.backend.RunStreamRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.grafana.backend.RunStreamRequest result) {
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.pluginContext_ = pluginContextBuilder_ == null
            ? pluginContext_
            : pluginContextBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.path_ = path_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.data_ = data_;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.grafana.backend.RunStreamRequest) {
        return mergeFrom((com.grafana.backend.RunStreamRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.grafana.backend.RunStreamRequest other) {
      if (other == com.grafana.backend.RunStreamRequest.getDefaultInstance()) return this;
      if (other.hasPluginContext()) {
        mergePluginContext(other.getPluginContext());
      }
      if (!other.getPath().isEmpty()) {
        path_ = other.path_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (other.getData() != com.google.protobuf.ByteString.EMPTY) {
        setData(other.getData());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              input.readMessage(
                  getPluginContextFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              path_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              data_ = input.readBytes();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private com.grafana.backend.PluginContext pluginContext_;
    private com.google.protobuf.SingleFieldBuilder<
        com.grafana.backend.PluginContext, com.grafana.backend.PluginContext.Builder, com.grafana.backend.PluginContextOrBuilder> pluginContextBuilder_;
    /**
     * <code>.pluginv2.PluginContext pluginContext = 1;</code>
     * @return Whether the pluginContext field is set.
     */
    public boolean hasPluginContext() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.pluginv2.PluginContext pluginContext = 1;</code>
     * @return The pluginContext.
     */
    public com.grafana.backend.PluginContext getPluginContext() {
      if (pluginContextBuilder_ == null) {
        return pluginContext_ == null ? com.grafana.backend.PluginContext.getDefaultInstance() : pluginContext_;
      } else {
        return pluginContextBuilder_.getMessage();
      }
    }
    /**
     * <code>.pluginv2.PluginContext pluginContext = 1;</code>
     */
    public Builder setPluginContext(com.grafana.backend.PluginContext value) {
      if (pluginContextBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        pluginContext_ = value;
      } else {
        pluginContextBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.pluginv2.PluginContext pluginContext = 1;</code>
     */
    public Builder setPluginContext(
        com.grafana.backend.PluginContext.Builder builderForValue) {
      if (pluginContextBuilder_ == null) {
        pluginContext_ = builderForValue.build();
      } else {
        pluginContextBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.pluginv2.PluginContext pluginContext = 1;</code>
     */
    public Builder mergePluginContext(com.grafana.backend.PluginContext value) {
      if (pluginContextBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          pluginContext_ != null &&
          pluginContext_ != com.grafana.backend.PluginContext.getDefaultInstance()) {
          getPluginContextBuilder().mergeFrom(value);
        } else {
          pluginContext_ = value;
        }
      } else {
        pluginContextBuilder_.mergeFrom(value);
      }
      if (pluginContext_ != null) {
        bitField0_ |= 0x00000001;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.pluginv2.PluginContext pluginContext = 1;</code>
     */
    public Builder clearPluginContext() {
      bitField0_ = (bitField0_ & ~0x00000001);
      pluginContext_ = null;
      if (pluginContextBuilder_ != null) {
        pluginContextBuilder_.dispose();
        pluginContextBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.pluginv2.PluginContext pluginContext = 1;</code>
     */
    public com.grafana.backend.PluginContext.Builder getPluginContextBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getPluginContextFieldBuilder().getBuilder();
    }
    /**
     * <code>.pluginv2.PluginContext pluginContext = 1;</code>
     */
    public com.grafana.backend.PluginContextOrBuilder getPluginContextOrBuilder() {
      if (pluginContextBuilder_ != null) {
        return pluginContextBuilder_.getMessageOrBuilder();
      } else {
        return pluginContext_ == null ?
            com.grafana.backend.PluginContext.getDefaultInstance() : pluginContext_;
      }
    }
    /**
     * <code>.pluginv2.PluginContext pluginContext = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        com.grafana.backend.PluginContext, com.grafana.backend.PluginContext.Builder, com.grafana.backend.PluginContextOrBuilder> 
        getPluginContextFieldBuilder() {
      if (pluginContextBuilder_ == null) {
        pluginContextBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            com.grafana.backend.PluginContext, com.grafana.backend.PluginContext.Builder, com.grafana.backend.PluginContextOrBuilder>(
                getPluginContext(),
                getParentForChildren(),
                isClean());
        pluginContext_ = null;
      }
      return pluginContextBuilder_;
    }

    private java.lang.Object path_ = "";
    /**
     * <pre>
     * path part of a channel.
     * </pre>
     *
     * <code>string path = 2;</code>
     * @return The path.
     */
    public java.lang.String getPath() {
      java.lang.Object ref = path_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        path_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * path part of a channel.
     * </pre>
     *
     * <code>string path = 2;</code>
     * @return The bytes for path.
     */
    public com.google.protobuf.ByteString
        getPathBytes() {
      java.lang.Object ref = path_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        path_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * path part of a channel.
     * </pre>
     *
     * <code>string path = 2;</code>
     * @param value The path to set.
     * @return This builder for chaining.
     */
    public Builder setPath(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      path_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * path part of a channel.
     * </pre>
     *
     * <code>string path = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPath() {
      path_ = getDefaultInstance().getPath();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * path part of a channel.
     * </pre>
     *
     * <code>string path = 2;</code>
     * @param value The bytes for path to set.
     * @return This builder for chaining.
     */
    public Builder setPathBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      path_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString data_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <pre>
     * optional raw data. May be used as an extra payload supplied upon subscription.
     * For example, can contain JSON query object.
     * </pre>
     *
     * <code>bytes data = 3;</code>
     * @return The data.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getData() {
      return data_;
    }
    /**
     * <pre>
     * optional raw data. May be used as an extra payload supplied upon subscription.
     * For example, can contain JSON query object.
     * </pre>
     *
     * <code>bytes data = 3;</code>
     * @param value The data to set.
     * @return This builder for chaining.
     */
    public Builder setData(com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      data_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * optional raw data. May be used as an extra payload supplied upon subscription.
     * For example, can contain JSON query object.
     * </pre>
     *
     * <code>bytes data = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearData() {
      bitField0_ = (bitField0_ & ~0x00000004);
      data_ = getDefaultInstance().getData();
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:pluginv2.RunStreamRequest)
  }

  // @@protoc_insertion_point(class_scope:pluginv2.RunStreamRequest)
  private static final com.grafana.backend.RunStreamRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.grafana.backend.RunStreamRequest();
  }

  public static com.grafana.backend.RunStreamRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RunStreamRequest>
      PARSER = new com.google.protobuf.AbstractParser<RunStreamRequest>() {
    @java.lang.Override
    public RunStreamRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<RunStreamRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RunStreamRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.grafana.backend.RunStreamRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

