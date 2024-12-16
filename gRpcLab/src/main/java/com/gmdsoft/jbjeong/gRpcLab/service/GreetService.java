package com.gmdsoft.jbjeong.gRpcLab.service;

import com.gmdsoft.jbjeong.gRpcLab.GreeterGrpc;
import com.gmdsoft.jbjeong.gRpcLab.HelloWorldProto;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetService extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloWorldProto.HelloRequest request, StreamObserver<HelloWorldProto.HelloReply> responseObserver) {
        String greeting = "Hello, " + request.getName() + "!";
        HelloWorldProto.HelloReply reply = HelloWorldProto.HelloReply.newBuilder()
                .setMessage(greeting)
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
