package com.example.demo.test.api;

import com.example.demo.test.domain.around.operation.OperationBoardType;
import lombok.Getter;

@Getter
public class AroundOperationRequest {

    private String title;

    private String startDateTime;

    private String endDateTime;

    private boolean active;

    private int displayOrder;

    private OperationBoardType type;
}
