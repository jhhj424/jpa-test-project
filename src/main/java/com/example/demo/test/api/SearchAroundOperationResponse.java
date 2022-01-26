package com.example.demo.test.api;

import com.example.demo.test.domain.around.operation.OperationBoard;
import com.example.demo.test.domain.around.operation.OperationBoardType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class SearchAroundOperationResponse {

    private Long id;

    private OperationBoardType type;

    private String title;

    private boolean active;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private int displayOrder;

    private String code;

//    private List<OperationBoardMap> operationBoardMaps;

    public static SearchAroundOperationResponse from(OperationBoard operationBoard) {

        return SearchAroundOperationResponse.builder()
                .id(operationBoard.getId())
                .type(operationBoard.getType())
                .title(operationBoard.getTitle())
                .active(operationBoard.isActive())
                .startDateTime(operationBoard.getStartDateTime())
                .endDateTime(operationBoard.getEndDateTime())
                .displayOrder(operationBoard.getDisplayOrder())
                .code(operationBoard.getCode())
//                .operationBoardMaps(operationBoard.getOperationBoardMaps())
                .build();
    }
}
