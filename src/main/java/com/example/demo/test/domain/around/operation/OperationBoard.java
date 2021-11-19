package com.example.demo.test.domain.around.operation;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class OperationBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OperationBoardType type;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private LocalDateTime startDateTime;

    @Column(nullable = false)
    private LocalDateTime endDateTime;

    @Column(nullable = false)
    private int displayOrder;

    @Column(nullable = false)
    private String code;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "operation_board_id")
    private List<OperationBoardMap> operationBoardMaps = new ArrayList<>();

    @Builder
    public OperationBoard(OperationBoardType type, String title, boolean active, LocalDateTime startDateTime, LocalDateTime endDateTime, int displayOrder, List<OperationBoardMap> operationBoardMaps) {
        this.type = type;
        this.title = title;
        this.active = true;
        this.startDateTime = LocalDateTime.now();
        this.endDateTime = LocalDateTime.now();
        this.displayOrder = displayOrder;
        this.operationBoardMaps = operationBoardMaps;
        this.code = "CODE";
    }

    public void update(OperationBoard operationBoard) {
        this.type = operationBoard.type;
        this.title = operationBoard.title;
        this.active = operationBoard.active;
        this.startDateTime = operationBoard.startDateTime;
        this.endDateTime = operationBoard.endDateTime;

        this.operationBoardMaps.clear();
        this.operationBoardMaps.addAll(operationBoard.operationBoardMaps);
    }

    public void updateDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public void updateActiveFalse() {
        this.active = false;
        this.displayOrder = -1;
    }

}
