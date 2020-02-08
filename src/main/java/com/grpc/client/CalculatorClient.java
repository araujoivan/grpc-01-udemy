/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grpc.client;

import com.proto.calculator.AddRequest;
import com.proto.calculator.AddResponse;
import com.proto.calculator.AddServiceGrpc;
import com.proto.calculator.Parcels;
import io.grpc.ManagedChannel;

/**
 *
 * @author Eder_Crespo
 */
public class CalculatorClient extends ClientChannelService {
    
    
    public static void main(String[] args) {
        new CalculatorClient();
    }

    @Override
    protected void performRequest(ManagedChannel channel) {
        
        final Parcels parcels = Parcels.newBuilder()
                .setFirstNumber(10)
                .setSecondNumber(90)
                .build();
        
        
        final AddRequest request = AddRequest.newBuilder()
                .setParcels(parcels)
                .build();
         
        final AddServiceGrpc.AddServiceBlockingStub client = AddServiceGrpc.newBlockingStub(channel);
        
        final AddResponse response = client.add(request);
        
        System.out.println(response.getTotal());
    }  
}
