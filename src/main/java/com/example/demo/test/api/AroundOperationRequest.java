package com.example.demo.test.api;

import com.example.demo.test.domain.around.operation.OperationBoard;
import com.example.demo.test.domain.around.operation.OperationBoardMap;
import com.example.demo.test.domain.around.operation.OperationBoardType;
import lombok.Getter;

import java.util.List;

@Getter
public class AroundOperationRequest {

    private String title;

    private String startDateTime;

    private String endDateTime;

    private boolean active;

    private int displayOrder;

    private OperationBoardType type;

    public OperationBoard toEntity(List<OperationBoardMap> operationBoardMaps) {

        return OperationBoard.builder()
                .title(this.title)
//                .startDateTime(this.startDateTime)
//                .endDateTime(this.endDateTime)
                .displayOrder(this.displayOrder)
                .type(this.type)
                .operationBoardMaps(operationBoardMaps)
                .build();
    }
}
