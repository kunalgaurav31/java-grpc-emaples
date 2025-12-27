package greeting.client;

import io.grpc.*;

public final class LogInterceptor implements ClientInterceptor {
    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
            MethodDescriptor<ReqT, RespT> method,
            CallOptions callOptions,
            Channel next) {
        
        System.out.println("Calling: " + method.getFullMethodName());
        return next.newCall(method, callOptions);
    }
}
