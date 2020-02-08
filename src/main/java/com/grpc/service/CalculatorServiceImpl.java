/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grpc.service;

import com.proto.calculator.AddRequest;
import com.proto.calculator.AddResponse;
import com.proto.calculator.AddServiceGrpc;
import com.proto.calculator.Parcels;
import io.grpc.stub.StreamObserver;

/**
 *
 * @author Eder_Crespo
 */
public class CalculatorServiceImpl extends AddServiceGrpc.AddServiceImplBase {

    @Override
    public void add(AddRequest request, StreamObserver<AddResponse> responseObserver) {
              
        final Parcels parcels = request.getParcels();
         
        final AddResponse response = AddResponse.newBuilder()
                .setTotal(parcels.getFirstNumber() + parcels.getSecondNumber())
                .build();
        
        responseObserver.onNext(response);
        responseObserver.onCompleted();   
    }
}
