package greeting.server;

import io.grpc.*;

public final class LogInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call,
            Metadata headers,
            ServerCallHandler<ReqT, RespT> next) {
        
        System.out.println("Received call: " + call.getMethodDescriptor().getFullMethodName());
        return next.startCall(call, headers);
    }
}
