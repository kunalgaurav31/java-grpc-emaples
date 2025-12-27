package greeting.client;

import io.grpc.*;

public final class AddHeaderInterceptor implements ClientInterceptor {
    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
            MethodDescriptor<ReqT, RespT> method,
            CallOptions callOptions,
            Channel next) {
        
        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                // Add custom headers
                headers.put(Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER), "Bearer token123");
                headers.put(Metadata.Key.of("client-id", Metadata.ASCII_STRING_MARSHALLER), "my-client");
                super.start(responseListener, headers);
            }
        };
    }
}
