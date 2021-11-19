package com.example.demo.test.domain.around.operation.styler;

import com.example.demo.test.domain.around.operation.OperationBoardMap;
import com.example.demo.test.domain.around.operation.OperationBoardType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue(OperationBoardType.Values.STYLER)
@Entity
public class OperationBoardStylerMap extends OperationBoardMap {

    @Id
    private Long id;

    @Column(nullable = false)
    private Long stylerId;

    public OperationBoardStylerMap(Long stylerId) {
        super(OperationBoardType.STYLER);
        this.stylerId = stylerId;
    }
}
