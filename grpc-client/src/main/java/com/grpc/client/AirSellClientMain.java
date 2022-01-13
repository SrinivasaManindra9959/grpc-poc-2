package com.grpc.client;

import com.grpc.client.SellAsync;
import com.grpc.stub.Airsell;
import com.grpc.stub.SellGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@SpringBootApplication(scanBasePackages = {"com.grpc.*"})
public class AirSellClientMain {
    public static void main(String[] args) {
        SpringApplication.run(AirSellClientMain.class,args);
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9000).
                usePlaintext().build();
        Long timeout = Constant.timeout;
        SellGrpc.SellStub sell = SellGrpc.newStub(channel);
        Airsell.SellRequest request = Airsell.SellRequest.newBuilder().setId(1).setSellType("DCS").build();
        Airsell.Empty empty = Airsell.Empty.newBuilder().build();
        sell.withDeadlineAfter(timeout, TimeUnit.MILLISECONDS).
                createSell(request,new SellAsync());
        sell.withDeadlineAfter(timeout, TimeUnit.MILLISECONDS).
                updateSell(request,new SellAsync());
        sell.withDeadlineAfter(timeout, TimeUnit.MILLISECONDS).
                getSells(empty,new SellAsync());

    }

}
