package calculator.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.proto.calculator.CalculatorServiceGrpc;
import com.proto.calculator.Calculator.CalculatorRequest;
import com.proto.calculator.Calculator.CalculatorResponse;

public class CalculatorClient {

    private static void doAdd(ManagedChannel channel, int number1, int number2) {
        System.out.println("Calling add operation...");
        CalculatorServiceGrpc.CalculatorServiceBlockingStub stub = CalculatorServiceGrpc.newBlockingStub(channel);
        
        CalculatorResponse response = stub.add(
            CalculatorRequest.newBuilder()
                .setNumber1(number1)
                .setNumber2(number2)
                .build()
        );

        System.out.println(number1 + " + " + number2 + " = " + response.getSum());
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: <operation> <number1> <number2>");
            System.out.println("Example: add 10 20");
            return;
        }

        ManagedChannel channel = ManagedChannelBuilder
            .forAddress("localhost", 50052)
            .usePlaintext()
            .build();

        try {
            String operation = args[0];
            int number1 = Integer.parseInt(args[1]);
            int number2 = Integer.parseInt(args[2]);

            switch (operation) {
                case "add":
                    doAdd(channel, number1, number2);
                    break;
                default:
                    System.out.println("Unknown operation: " + operation);
                    System.out.println("Available operations: add");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Arguments must be valid integers");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Shutting down channel...");
            channel.shutdown();
        }
    }
}
