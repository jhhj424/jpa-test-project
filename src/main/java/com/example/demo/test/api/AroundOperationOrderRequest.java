package com.example.demo.test.api;

import lombok.Getter;

import java.util.List;

@Getter
public class AroundOperationOrderRequest {

    private List<OperationOrder> operationOrders;

    @Getter
    public static class OperationOrder {
        private long id;
        private int displayOrder;
    }
}
