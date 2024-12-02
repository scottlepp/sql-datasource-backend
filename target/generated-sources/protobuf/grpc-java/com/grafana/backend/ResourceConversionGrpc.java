package com.grafana.backend;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * ResourceConversion is a service that can be used to convert resources between versions
 * See: https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definition-versioning/#webhook-request-and-response
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: backend.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ResourceConversionGrpc {

  private ResourceConversionGrpc() {}

  public static final java.lang.String SERVICE_NAME = "pluginv2.ResourceConversion";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grafana.backend.ConversionRequest,
      com.grafana.backend.ConversionResponse> getConvertObjectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ConvertObjects",
      requestType = com.grafana.backend.ConversionRequest.class,
      responseType = com.grafana.backend.ConversionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grafana.backend.ConversionRequest,
      com.grafana.backend.ConversionResponse> getConvertObjectsMethod() {
    io.grpc.MethodDescriptor<com.grafana.backend.ConversionRequest, com.grafana.backend.ConversionResponse> getConvertObjectsMethod;
    if ((getConvertObjectsMethod = ResourceConversionGrpc.getConvertObjectsMethod) == null) {
      synchronized (ResourceConversionGrpc.class) {
        if ((getConvertObjectsMethod = ResourceConversionGrpc.getConvertObjectsMethod) == null) {
          ResourceConversionGrpc.getConvertObjectsMethod = getConvertObjectsMethod =
              io.grpc.MethodDescriptor.<com.grafana.backend.ConversionRequest, com.grafana.backend.ConversionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ConvertObjects"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grafana.backend.ConversionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grafana.backend.ConversionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ResourceConversionMethodDescriptorSupplier("ConvertObjects"))
              .build();
        }
      }
    }
    return getConvertObjectsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ResourceConversionStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ResourceConversionStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ResourceConversionStub>() {
        @java.lang.Override
        public ResourceConversionStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ResourceConversionStub(channel, callOptions);
        }
      };
    return ResourceConversionStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ResourceConversionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ResourceConversionBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ResourceConversionBlockingStub>() {
        @java.lang.Override
        public ResourceConversionBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ResourceConversionBlockingStub(channel, callOptions);
        }
      };
    return ResourceConversionBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ResourceConversionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ResourceConversionFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ResourceConversionFutureStub>() {
        @java.lang.Override
        public ResourceConversionFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ResourceConversionFutureStub(channel, callOptions);
        }
      };
    return ResourceConversionFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * ResourceConversion is a service that can be used to convert resources between versions
   * See: https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definition-versioning/#webhook-request-and-response
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Convert objects to a target version
     * </pre>
     */
    default void convertObjects(com.grafana.backend.ConversionRequest request,
        io.grpc.stub.StreamObserver<com.grafana.backend.ConversionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getConvertObjectsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ResourceConversion.
   * <pre>
   * ResourceConversion is a service that can be used to convert resources between versions
   * See: https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definition-versioning/#webhook-request-and-response
   * </pre>
   */
  public static abstract class ResourceConversionImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ResourceConversionGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ResourceConversion.
   * <pre>
   * ResourceConversion is a service that can be used to convert resources between versions
   * See: https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definition-versioning/#webhook-request-and-response
   * </pre>
   */
  public static final class ResourceConversionStub
      extends io.grpc.stub.AbstractAsyncStub<ResourceConversionStub> {
    private ResourceConversionStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResourceConversionStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ResourceConversionStub(channel, callOptions);
    }

    /**
     * <pre>
     * Convert objects to a target version
     * </pre>
     */
    public void convertObjects(com.grafana.backend.ConversionRequest request,
        io.grpc.stub.StreamObserver<com.grafana.backend.ConversionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getConvertObjectsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ResourceConversion.
   * <pre>
   * ResourceConversion is a service that can be used to convert resources between versions
   * See: https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definition-versioning/#webhook-request-and-response
   * </pre>
   */
  public static final class ResourceConversionBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ResourceConversionBlockingStub> {
    private ResourceConversionBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResourceConversionBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ResourceConversionBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Convert objects to a target version
     * </pre>
     */
    public com.grafana.backend.ConversionResponse convertObjects(com.grafana.backend.ConversionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getConvertObjectsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ResourceConversion.
   * <pre>
   * ResourceConversion is a service that can be used to convert resources between versions
   * See: https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definition-versioning/#webhook-request-and-response
   * </pre>
   */
  public static final class ResourceConversionFutureStub
      extends io.grpc.stub.AbstractFutureStub<ResourceConversionFutureStub> {
    private ResourceConversionFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResourceConversionFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ResourceConversionFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Convert objects to a target version
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grafana.backend.ConversionResponse> convertObjects(
        com.grafana.backend.ConversionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getConvertObjectsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONVERT_OBJECTS = 0;

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
        case METHODID_CONVERT_OBJECTS:
          serviceImpl.convertObjects((com.grafana.backend.ConversionRequest) request,
              (io.grpc.stub.StreamObserver<com.grafana.backend.ConversionResponse>) responseObserver);
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
          getConvertObjectsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.grafana.backend.ConversionRequest,
              com.grafana.backend.ConversionResponse>(
                service, METHODID_CONVERT_OBJECTS)))
        .build();
  }

  private static abstract class ResourceConversionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ResourceConversionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grafana.backend.BackendProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ResourceConversion");
    }
  }

  private static final class ResourceConversionFileDescriptorSupplier
      extends ResourceConversionBaseDescriptorSupplier {
    ResourceConversionFileDescriptorSupplier() {}
  }

  private static final class ResourceConversionMethodDescriptorSupplier
      extends ResourceConversionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ResourceConversionMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ResourceConversionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ResourceConversionFileDescriptorSupplier())
              .addMethod(getConvertObjectsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
