package calculator.server;

import java.io.IOException;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class CalculatorServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 50052;

        System.out.println("Starting Calculator Server on port: " + port);

        Server server = ServerBuilder.forPort(port)
            .addService(new CalculatorServiceImpl())
            .build();

        server.start();
        System.out.println("Calculator Server started successfully!");
        System.out.println("Listening on port: " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received shutdown request");
            server.shutdown();
            System.out.println("Server stopped successfully");
        }));

        server.awaitTermination();
    }
}
