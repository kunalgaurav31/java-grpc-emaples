package calculator.server;

import com.proto.calculator.CalculatorServiceGrpc;
import com.proto.calculator.Calculator.CalculatorRequest;
import com.proto.calculator.Calculator.CalculatorResponse;
import io.grpc.stub.StreamObserver;

public class CalculatorServiceImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {

    @Override
    public void add(CalculatorRequest request, StreamObserver<CalculatorResponse> responseObserver) {
        int number1 = request.getNumber1();
        int number2 = request.getNumber2();
        int sum = number1 + number2;

        System.out.println("Received add request: " + number1 + " + " + number2);

        CalculatorResponse response = CalculatorResponse.newBuilder()
            .setSum(sum)
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
