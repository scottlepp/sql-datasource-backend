package com.grafana.backend;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: backend.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StreamGrpc {

  private StreamGrpc() {}

  public static final java.lang.String SERVICE_NAME = "pluginv2.Stream";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grafana.backend.SubscribeStreamRequest,
      com.grafana.backend.SubscribeStreamResponse> getSubscribeStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubscribeStream",
      requestType = com.grafana.backend.SubscribeStreamRequest.class,
      responseType = com.grafana.backend.SubscribeStreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grafana.backend.SubscribeStreamRequest,
      com.grafana.backend.SubscribeStreamResponse> getSubscribeStreamMethod() {
    io.grpc.MethodDescriptor<com.grafana.backend.SubscribeStreamRequest, com.grafana.backend.SubscribeStreamResponse> getSubscribeStreamMethod;
    if ((getSubscribeStreamMethod = StreamGrpc.getSubscribeStreamMethod) == null) {
      synchronized (StreamGrpc.class) {
        if ((getSubscribeStreamMethod = StreamGrpc.getSubscribeStreamMethod) == null) {
          StreamGrpc.getSubscribeStreamMethod = getSubscribeStreamMethod =
              io.grpc.MethodDescriptor.<com.grafana.backend.SubscribeStreamRequest, com.grafana.backend.SubscribeStreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubscribeStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grafana.backend.SubscribeStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grafana.backend.SubscribeStreamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StreamMethodDescriptorSupplier("SubscribeStream"))
              .build();
        }
      }
    }
    return getSubscribeStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grafana.backend.RunStreamRequest,
      com.grafana.backend.StreamPacket> getRunStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunStream",
      requestType = com.grafana.backend.RunStreamRequest.class,
      responseType = com.grafana.backend.StreamPacket.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.grafana.backend.RunStreamRequest,
      com.grafana.backend.StreamPacket> getRunStreamMethod() {
    io.grpc.MethodDescriptor<com.grafana.backend.RunStreamRequest, com.grafana.backend.StreamPacket> getRunStreamMethod;
    if ((getRunStreamMethod = StreamGrpc.getRunStreamMethod) == null) {
      synchronized (StreamGrpc.class) {
        if ((getRunStreamMethod = StreamGrpc.getRunStreamMethod) == null) {
          StreamGrpc.getRunStreamMethod = getRunStreamMethod =
              io.grpc.MethodDescriptor.<com.grafana.backend.RunStreamRequest, com.grafana.backend.StreamPacket>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grafana.backend.RunStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grafana.backend.StreamPacket.getDefaultInstance()))
              .setSchemaDescriptor(new StreamMethodDescriptorSupplier("RunStream"))
              .build();
        }
      }
    }
    return getRunStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grafana.backend.PublishStreamRequest,
      com.grafana.backend.PublishStreamResponse> getPublishStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PublishStream",
      requestType = com.grafana.backend.PublishStreamRequest.class,
      responseType = com.grafana.backend.PublishStreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grafana.backend.PublishStreamRequest,
      com.grafana.backend.PublishStreamResponse> getPublishStreamMethod() {
    io.grpc.MethodDescriptor<com.grafana.backend.PublishStreamRequest, com.grafana.backend.PublishStreamResponse> getPublishStreamMethod;
    if ((getPublishStreamMethod = StreamGrpc.getPublishStreamMethod) == null) {
      synchronized (StreamGrpc.class) {
        if ((getPublishStreamMethod = StreamGrpc.getPublishStreamMethod) == null) {
          StreamGrpc.getPublishStreamMethod = getPublishStreamMethod =
              io.grpc.MethodDescriptor.<com.grafana.backend.PublishStreamRequest, com.grafana.backend.PublishStreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PublishStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grafana.backend.PublishStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grafana.backend.PublishStreamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StreamMethodDescriptorSupplier("PublishStream"))
              .build();
        }
      }
    }
    return getPublishStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StreamStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StreamStub>() {
        @java.lang.Override
        public StreamStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StreamStub(channel, callOptions);
        }
      };
    return StreamStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StreamBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StreamBlockingStub>() {
        @java.lang.Override
        public StreamBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StreamBlockingStub(channel, callOptions);
        }
      };
    return StreamBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StreamFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StreamFutureStub>() {
        @java.lang.Override
        public StreamFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StreamFutureStub(channel, callOptions);
        }
      };
    return StreamFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * SubscribeStream called when a user tries to subscribe to a plugin/datasource
     * managed channel path – thus plugin can check subscribe permissions and communicate
     * options with Grafana Core. When the first subscriber joins a channel, RunStream
     * will be called.
     * </pre>
     */
    default void subscribeStream(com.grafana.backend.SubscribeStreamRequest request,
        io.grpc.stub.StreamObserver<com.grafana.backend.SubscribeStreamResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * RunStream will be initiated by Grafana to consume a stream. RunStream will be
     * called once for the first client successfully subscribed to a channel path.
     * When Grafana detects that there are no longer any subscribers inside a channel,
     * the call will be terminated until next active subscriber appears. Call termination
     * can happen with a delay.
     * </pre>
     */
    default void runStream(com.grafana.backend.RunStreamRequest request,
        io.grpc.stub.StreamObserver<com.grafana.backend.StreamPacket> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRunStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * PublishStream called when a user tries to publish to a plugin/datasource
     * managed channel path. Here plugin can check publish permissions and
     * modify publication data if required.
     * </pre>
     */
    default void publishStream(com.grafana.backend.PublishStreamRequest request,
        io.grpc.stub.StreamObserver<com.grafana.backend.PublishStreamResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPublishStreamMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Stream.
   */
  public static abstract class StreamImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return StreamGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Stream.
   */
  public static final class StreamStub
      extends io.grpc.stub.AbstractAsyncStub<StreamStub> {
    private StreamStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamStub(channel, callOptions);
    }

    /**
     * <pre>
     * SubscribeStream called when a user tries to subscribe to a plugin/datasource
     * managed channel path – thus plugin can check subscribe permissions and communicate
     * options with Grafana Core. When the first subscriber joins a channel, RunStream
     * will be called.
     * </pre>
     */
    public void subscribeStream(com.grafana.backend.SubscribeStreamRequest request,
        io.grpc.stub.StreamObserver<com.grafana.backend.SubscribeStreamResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubscribeStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RunStream will be initiated by Grafana to consume a stream. RunStream will be
     * called once for the first client successfully subscribed to a channel path.
     * When Grafana detects that there are no longer any subscribers inside a channel,
     * the call will be terminated until next active subscriber appears. Call termination
     * can happen with a delay.
     * </pre>
     */
    public void runStream(com.grafana.backend.RunStreamRequest request,
        io.grpc.stub.StreamObserver<com.grafana.backend.StreamPacket> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getRunStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * PublishStream called when a user tries to publish to a plugin/datasource
     * managed channel path. Here plugin can check publish permissions and
     * modify publication data if required.
     * </pre>
     */
    public void publishStream(com.grafana.backend.PublishStreamRequest request,
        io.grpc.stub.StreamObserver<com.grafana.backend.PublishStreamResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPublishStreamMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Stream.
   */
  public static final class StreamBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<StreamBlockingStub> {
    private StreamBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * SubscribeStream called when a user tries to subscribe to a plugin/datasource
     * managed channel path – thus plugin can check subscribe permissions and communicate
     * options with Grafana Core. When the first subscriber joins a channel, RunStream
     * will be called.
     * </pre>
     */
    public com.grafana.backend.SubscribeStreamResponse subscribeStream(com.grafana.backend.SubscribeStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubscribeStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * RunStream will be initiated by Grafana to consume a stream. RunStream will be
     * called once for the first client successfully subscribed to a channel path.
     * When Grafana detects that there are no longer any subscribers inside a channel,
     * the call will be terminated until next active subscriber appears. Call termination
     * can happen with a delay.
     * </pre>
     */
    public java.util.Iterator<com.grafana.backend.StreamPacket> runStream(
        com.grafana.backend.RunStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getRunStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * PublishStream called when a user tries to publish to a plugin/datasource
     * managed channel path. Here plugin can check publish permissions and
     * modify publication data if required.
     * </pre>
     */
    public com.grafana.backend.PublishStreamResponse publishStream(com.grafana.backend.PublishStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPublishStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Stream.
   */
  public static final class StreamFutureStub
      extends io.grpc.stub.AbstractFutureStub<StreamFutureStub> {
    private StreamFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * SubscribeStream called when a user tries to subscribe to a plugin/datasource
     * managed channel path – thus plugin can check subscribe permissions and communicate
     * options with Grafana Core. When the first subscriber joins a channel, RunStream
     * will be called.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grafana.backend.SubscribeStreamResponse> subscribeStream(
        com.grafana.backend.SubscribeStreamRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubscribeStreamMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * PublishStream called when a user tries to publish to a plugin/datasource
     * managed channel path. Here plugin can check publish permissions and
     * modify publication data if required.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grafana.backend.PublishStreamResponse> publishStream(
        com.grafana.backend.PublishStreamRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPublishStreamMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUBSCRIBE_STREAM = 0;
  private static final int METHODID_RUN_STREAM = 1;
  private static final int METHODID_PUBLISH_STREAM = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBSCRIBE_STREAM:
          serviceImpl.subscribeStream((com.grafana.backend.SubscribeStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.grafana.backend.SubscribeStreamResponse>) responseObserver);
          break;
        case METHODID_RUN_STREAM:
          serviceImpl.runStream((com.grafana.backend.RunStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.grafana.backend.StreamPacket>) responseObserver);
          break;
        case METHODID_PUBLISH_STREAM:
          serviceImpl.publishStream((com.grafana.backend.PublishStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.grafana.backend.PublishStreamResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSubscribeStreamMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.grafana.backend.SubscribeStreamRequest,
              com.grafana.backend.SubscribeStreamResponse>(
                service, METHODID_SUBSCRIBE_STREAM)))
        .addMethod(
          getRunStreamMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.grafana.backend.RunStreamRequest,
              com.grafana.backend.StreamPacket>(
                service, METHODID_RUN_STREAM)))
        .addMethod(
          getPublishStreamMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.grafana.backend.PublishStreamRequest,
              com.grafana.backend.PublishStreamResponse>(
                service, METHODID_PUBLISH_STREAM)))
        .build();
  }

  private static abstract class StreamBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StreamBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grafana.backend.BackendProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Stream");
    }
  }

  private static final class StreamFileDescriptorSupplier
      extends StreamBaseDescriptorSupplier {
    StreamFileDescriptorSupplier() {}
  }

  private static final class StreamMethodDescriptorSupplier
      extends StreamBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    StreamMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StreamGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StreamFileDescriptorSupplier())
              .addMethod(getSubscribeStreamMethod())
              .addMethod(getRunStreamMethod())
              .addMethod(getPublishStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
