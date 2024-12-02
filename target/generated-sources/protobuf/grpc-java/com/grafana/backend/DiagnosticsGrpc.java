package com.grafana.backend;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: backend.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DiagnosticsGrpc {

  private DiagnosticsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "pluginv2.Diagnostics";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grafana.backend.CheckHealthRequest,
      com.grafana.backend.CheckHealthResponse> getCheckHealthMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckHealth",
      requestType = com.grafana.backend.CheckHealthRequest.class,
      responseType = com.grafana.backend.CheckHealthResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grafana.backend.CheckHealthRequest,
      com.grafana.backend.CheckHealthResponse> getCheckHealthMethod() {
    io.grpc.MethodDescriptor<com.grafana.backend.CheckHealthRequest, com.grafana.backend.CheckHealthResponse> getCheckHealthMethod;
    if ((getCheckHealthMethod = DiagnosticsGrpc.getCheckHealthMethod) == null) {
      synchronized (DiagnosticsGrpc.class) {
        if ((getCheckHealthMethod = DiagnosticsGrpc.getCheckHealthMethod) == null) {
          DiagnosticsGrpc.getCheckHealthMethod = getCheckHealthMethod =
              io.grpc.MethodDescriptor.<com.grafana.backend.CheckHealthRequest, com.grafana.backend.CheckHealthResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckHealth"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grafana.backend.CheckHealthRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grafana.backend.CheckHealthResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DiagnosticsMethodDescriptorSupplier("CheckHealth"))
              .build();
        }
      }
    }
    return getCheckHealthMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grafana.backend.CollectMetricsRequest,
      com.grafana.backend.CollectMetricsResponse> getCollectMetricsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CollectMetrics",
      requestType = com.grafana.backend.CollectMetricsRequest.class,
      responseType = com.grafana.backend.CollectMetricsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grafana.backend.CollectMetricsRequest,
      com.grafana.backend.CollectMetricsResponse> getCollectMetricsMethod() {
    io.grpc.MethodDescriptor<com.grafana.backend.CollectMetricsRequest, com.grafana.backend.CollectMetricsResponse> getCollectMetricsMethod;
    if ((getCollectMetricsMethod = DiagnosticsGrpc.getCollectMetricsMethod) == null) {
      synchronized (DiagnosticsGrpc.class) {
        if ((getCollectMetricsMethod = DiagnosticsGrpc.getCollectMetricsMethod) == null) {
          DiagnosticsGrpc.getCollectMetricsMethod = getCollectMetricsMethod =
              io.grpc.MethodDescriptor.<com.grafana.backend.CollectMetricsRequest, com.grafana.backend.CollectMetricsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CollectMetrics"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grafana.backend.CollectMetricsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grafana.backend.CollectMetricsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DiagnosticsMethodDescriptorSupplier("CollectMetrics"))
              .build();
        }
      }
    }
    return getCollectMetricsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DiagnosticsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DiagnosticsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DiagnosticsStub>() {
        @java.lang.Override
        public DiagnosticsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DiagnosticsStub(channel, callOptions);
        }
      };
    return DiagnosticsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DiagnosticsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DiagnosticsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DiagnosticsBlockingStub>() {
        @java.lang.Override
        public DiagnosticsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DiagnosticsBlockingStub(channel, callOptions);
        }
      };
    return DiagnosticsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DiagnosticsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DiagnosticsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DiagnosticsFutureStub>() {
        @java.lang.Override
        public DiagnosticsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DiagnosticsFutureStub(channel, callOptions);
        }
      };
    return DiagnosticsFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void checkHealth(com.grafana.backend.CheckHealthRequest request,
        io.grpc.stub.StreamObserver<com.grafana.backend.CheckHealthResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckHealthMethod(), responseObserver);
    }

    /**
     */
    default void collectMetrics(com.grafana.backend.CollectMetricsRequest request,
        io.grpc.stub.StreamObserver<com.grafana.backend.CollectMetricsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCollectMetricsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Diagnostics.
   */
  public static abstract class DiagnosticsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return DiagnosticsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Diagnostics.
   */
  public static final class DiagnosticsStub
      extends io.grpc.stub.AbstractAsyncStub<DiagnosticsStub> {
    private DiagnosticsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiagnosticsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DiagnosticsStub(channel, callOptions);
    }

    /**
     */
    public void checkHealth(com.grafana.backend.CheckHealthRequest request,
        io.grpc.stub.StreamObserver<com.grafana.backend.CheckHealthResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckHealthMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void collectMetrics(com.grafana.backend.CollectMetricsRequest request,
        io.grpc.stub.StreamObserver<com.grafana.backend.CollectMetricsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCollectMetricsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Diagnostics.
   */
  public static final class DiagnosticsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DiagnosticsBlockingStub> {
    private DiagnosticsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiagnosticsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DiagnosticsBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.grafana.backend.CheckHealthResponse checkHealth(com.grafana.backend.CheckHealthRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckHealthMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grafana.backend.CollectMetricsResponse collectMetrics(com.grafana.backend.CollectMetricsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCollectMetricsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Diagnostics.
   */
  public static final class DiagnosticsFutureStub
      extends io.grpc.stub.AbstractFutureStub<DiagnosticsFutureStub> {
    private DiagnosticsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiagnosticsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DiagnosticsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grafana.backend.CheckHealthResponse> checkHealth(
        com.grafana.backend.CheckHealthRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckHealthMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grafana.backend.CollectMetricsResponse> collectMetrics(
        com.grafana.backend.CollectMetricsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCollectMetricsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_HEALTH = 0;
  private static final int METHODID_COLLECT_METRICS = 1;

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
        case METHODID_CHECK_HEALTH:
          serviceImpl.checkHealth((com.grafana.backend.CheckHealthRequest) request,
              (io.grpc.stub.StreamObserver<com.grafana.backend.CheckHealthResponse>) responseObserver);
          break;
        case METHODID_COLLECT_METRICS:
          serviceImpl.collectMetrics((com.grafana.backend.CollectMetricsRequest) request,
              (io.grpc.stub.StreamObserver<com.grafana.backend.CollectMetricsResponse>) responseObserver);
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
          getCheckHealthMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.grafana.backend.CheckHealthRequest,
              com.grafana.backend.CheckHealthResponse>(
                service, METHODID_CHECK_HEALTH)))
        .addMethod(
          getCollectMetricsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.grafana.backend.CollectMetricsRequest,
              com.grafana.backend.CollectMetricsResponse>(
                service, METHODID_COLLECT_METRICS)))
        .build();
  }

  private static abstract class DiagnosticsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DiagnosticsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grafana.backend.BackendProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Diagnostics");
    }
  }

  private static final class DiagnosticsFileDescriptorSupplier
      extends DiagnosticsBaseDescriptorSupplier {
    DiagnosticsFileDescriptorSupplier() {}
  }

  private static final class DiagnosticsMethodDescriptorSupplier
      extends DiagnosticsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DiagnosticsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DiagnosticsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DiagnosticsFileDescriptorSupplier())
              .addMethod(getCheckHealthMethod())
              .addMethod(getCollectMetricsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
