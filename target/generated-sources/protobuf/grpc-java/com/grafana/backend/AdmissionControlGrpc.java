package com.grafana.backend;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Admission control is a service based on the kubernetes admission webhook patterns.
 * This service can be used to verify if objects are valid and convert between versions
 * See: https://github.com/kubernetes/kubernetes/blob/v1.30.0/pkg/apis/admission/types.go#L41
 * And: https://github.com/grafana/grafana-app-sdk/blob/main/resource/admission.go#L14
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: backend.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AdmissionControlGrpc {

  private AdmissionControlGrpc() {}

  public static final java.lang.String SERVICE_NAME = "pluginv2.AdmissionControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grafana.backend.AdmissionRequest,
      com.grafana.backend.ValidationResponse> getValidateAdmissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateAdmission",
      requestType = com.grafana.backend.AdmissionRequest.class,
      responseType = com.grafana.backend.ValidationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grafana.backend.AdmissionRequest,
      com.grafana.backend.ValidationResponse> getValidateAdmissionMethod() {
    io.grpc.MethodDescriptor<com.grafana.backend.AdmissionRequest, com.grafana.backend.ValidationResponse> getValidateAdmissionMethod;
    if ((getValidateAdmissionMethod = AdmissionControlGrpc.getValidateAdmissionMethod) == null) {
      synchronized (AdmissionControlGrpc.class) {
        if ((getValidateAdmissionMethod = AdmissionControlGrpc.getValidateAdmissionMethod) == null) {
          AdmissionControlGrpc.getValidateAdmissionMethod = getValidateAdmissionMethod =
              io.grpc.MethodDescriptor.<com.grafana.backend.AdmissionRequest, com.grafana.backend.ValidationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateAdmission"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grafana.backend.AdmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grafana.backend.ValidationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdmissionControlMethodDescriptorSupplier("ValidateAdmission"))
              .build();
        }
      }
    }
    return getValidateAdmissionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grafana.backend.AdmissionRequest,
      com.grafana.backend.MutationResponse> getMutateAdmissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MutateAdmission",
      requestType = com.grafana.backend.AdmissionRequest.class,
      responseType = com.grafana.backend.MutationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grafana.backend.AdmissionRequest,
      com.grafana.backend.MutationResponse> getMutateAdmissionMethod() {
    io.grpc.MethodDescriptor<com.grafana.backend.AdmissionRequest, com.grafana.backend.MutationResponse> getMutateAdmissionMethod;
    if ((getMutateAdmissionMethod = AdmissionControlGrpc.getMutateAdmissionMethod) == null) {
      synchronized (AdmissionControlGrpc.class) {
        if ((getMutateAdmissionMethod = AdmissionControlGrpc.getMutateAdmissionMethod) == null) {
          AdmissionControlGrpc.getMutateAdmissionMethod = getMutateAdmissionMethod =
              io.grpc.MethodDescriptor.<com.grafana.backend.AdmissionRequest, com.grafana.backend.MutationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MutateAdmission"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grafana.backend.AdmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grafana.backend.MutationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdmissionControlMethodDescriptorSupplier("MutateAdmission"))
              .build();
        }
      }
    }
    return getMutateAdmissionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AdmissionControlStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdmissionControlStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdmissionControlStub>() {
        @java.lang.Override
        public AdmissionControlStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdmissionControlStub(channel, callOptions);
        }
      };
    return AdmissionControlStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AdmissionControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdmissionControlBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdmissionControlBlockingStub>() {
        @java.lang.Override
        public AdmissionControlBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdmissionControlBlockingStub(channel, callOptions);
        }
      };
    return AdmissionControlBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AdmissionControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdmissionControlFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdmissionControlFutureStub>() {
        @java.lang.Override
        public AdmissionControlFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdmissionControlFutureStub(channel, callOptions);
        }
      };
    return AdmissionControlFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Admission control is a service based on the kubernetes admission webhook patterns.
   * This service can be used to verify if objects are valid and convert between versions
   * See: https://github.com/kubernetes/kubernetes/blob/v1.30.0/pkg/apis/admission/types.go#L41
   * And: https://github.com/grafana/grafana-app-sdk/blob/main/resource/admission.go#L14
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Validate a resource -- the response is a simple yes/no
     * </pre>
     */
    default void validateAdmission(com.grafana.backend.AdmissionRequest request,
        io.grpc.stub.StreamObserver<com.grafana.backend.ValidationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateAdmissionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Return a modified copy of the request that can be saved or a descriptive error
     * </pre>
     */
    default void mutateAdmission(com.grafana.backend.AdmissionRequest request,
        io.grpc.stub.StreamObserver<com.grafana.backend.MutationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMutateAdmissionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AdmissionControl.
   * <pre>
   * Admission control is a service based on the kubernetes admission webhook patterns.
   * This service can be used to verify if objects are valid and convert between versions
   * See: https://github.com/kubernetes/kubernetes/blob/v1.30.0/pkg/apis/admission/types.go#L41
   * And: https://github.com/grafana/grafana-app-sdk/blob/main/resource/admission.go#L14
   * </pre>
   */
  public static abstract class AdmissionControlImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AdmissionControlGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AdmissionControl.
   * <pre>
   * Admission control is a service based on the kubernetes admission webhook patterns.
   * This service can be used to verify if objects are valid and convert between versions
   * See: https://github.com/kubernetes/kubernetes/blob/v1.30.0/pkg/apis/admission/types.go#L41
   * And: https://github.com/grafana/grafana-app-sdk/blob/main/resource/admission.go#L14
   * </pre>
   */
  public static final class AdmissionControlStub
      extends io.grpc.stub.AbstractAsyncStub<AdmissionControlStub> {
    private AdmissionControlStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdmissionControlStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdmissionControlStub(channel, callOptions);
    }

    /**
     * <pre>
     * Validate a resource -- the response is a simple yes/no
     * </pre>
     */
    public void validateAdmission(com.grafana.backend.AdmissionRequest request,
        io.grpc.stub.StreamObserver<com.grafana.backend.ValidationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateAdmissionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Return a modified copy of the request that can be saved or a descriptive error
     * </pre>
     */
    public void mutateAdmission(com.grafana.backend.AdmissionRequest request,
        io.grpc.stub.StreamObserver<com.grafana.backend.MutationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMutateAdmissionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AdmissionControl.
   * <pre>
   * Admission control is a service based on the kubernetes admission webhook patterns.
   * This service can be used to verify if objects are valid and convert between versions
   * See: https://github.com/kubernetes/kubernetes/blob/v1.30.0/pkg/apis/admission/types.go#L41
   * And: https://github.com/grafana/grafana-app-sdk/blob/main/resource/admission.go#L14
   * </pre>
   */
  public static final class AdmissionControlBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AdmissionControlBlockingStub> {
    private AdmissionControlBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdmissionControlBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdmissionControlBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Validate a resource -- the response is a simple yes/no
     * </pre>
     */
    public com.grafana.backend.ValidationResponse validateAdmission(com.grafana.backend.AdmissionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateAdmissionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Return a modified copy of the request that can be saved or a descriptive error
     * </pre>
     */
    public com.grafana.backend.MutationResponse mutateAdmission(com.grafana.backend.AdmissionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMutateAdmissionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AdmissionControl.
   * <pre>
   * Admission control is a service based on the kubernetes admission webhook patterns.
   * This service can be used to verify if objects are valid and convert between versions
   * See: https://github.com/kubernetes/kubernetes/blob/v1.30.0/pkg/apis/admission/types.go#L41
   * And: https://github.com/grafana/grafana-app-sdk/blob/main/resource/admission.go#L14
   * </pre>
   */
  public static final class AdmissionControlFutureStub
      extends io.grpc.stub.AbstractFutureStub<AdmissionControlFutureStub> {
    private AdmissionControlFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdmissionControlFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdmissionControlFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Validate a resource -- the response is a simple yes/no
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grafana.backend.ValidationResponse> validateAdmission(
        com.grafana.backend.AdmissionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateAdmissionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Return a modified copy of the request that can be saved or a descriptive error
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grafana.backend.MutationResponse> mutateAdmission(
        com.grafana.backend.AdmissionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMutateAdmissionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_VALIDATE_ADMISSION = 0;
  private static final int METHODID_MUTATE_ADMISSION = 1;

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
        case METHODID_VALIDATE_ADMISSION:
          serviceImpl.validateAdmission((com.grafana.backend.AdmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.grafana.backend.ValidationResponse>) responseObserver);
          break;
        case METHODID_MUTATE_ADMISSION:
          serviceImpl.mutateAdmission((com.grafana.backend.AdmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.grafana.backend.MutationResponse>) responseObserver);
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
          getValidateAdmissionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.grafana.backend.AdmissionRequest,
              com.grafana.backend.ValidationResponse>(
                service, METHODID_VALIDATE_ADMISSION)))
        .addMethod(
          getMutateAdmissionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.grafana.backend.AdmissionRequest,
              com.grafana.backend.MutationResponse>(
                service, METHODID_MUTATE_ADMISSION)))
        .build();
  }

  private static abstract class AdmissionControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AdmissionControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grafana.backend.BackendProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AdmissionControl");
    }
  }

  private static final class AdmissionControlFileDescriptorSupplier
      extends AdmissionControlBaseDescriptorSupplier {
    AdmissionControlFileDescriptorSupplier() {}
  }

  private static final class AdmissionControlMethodDescriptorSupplier
      extends AdmissionControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AdmissionControlMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AdmissionControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AdmissionControlFileDescriptorSupplier())
              .addMethod(getValidateAdmissionMethod())
              .addMethod(getMutateAdmissionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
