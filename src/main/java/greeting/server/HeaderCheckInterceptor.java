package greeting.server;

import io.grpc.*;

public final class HeaderCheckInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call,
            Metadata headers,
            ServerCallHandler<ReqT, RespT> next) {
        
        // Example: Check for authorization header
        String authHeader = headers.get(Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER));
        System.out.println("Authorization header: " + authHeader);
        
        return next.startCall(call, headers);
    }
}
