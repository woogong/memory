package com.gmdsoft.jbjeong.gRpcLab.tester;

import com.gmdsoft.jbjeong.gRpcLab.GreeterGrpc;
import com.gmdsoft.jbjeong.gRpcLab.HelloWorldProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        // 채널 생성
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext() // TLS 비활성화 (개발 환경)
                .build();

        // 클라이언트 Stub 생성
        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);

        // 요청 전송 및 응답 수신
        HelloWorldProto.HelloRequest request = HelloWorldProto.HelloRequest.newBuilder()
                .setName("Alice")
                .build();

        HelloWorldProto.HelloReply reply = stub.sayHello(request);

        System.out.println("Response: " + reply.getMessage());

        // 채널 종료
        channel.shutdown();
    }
}
