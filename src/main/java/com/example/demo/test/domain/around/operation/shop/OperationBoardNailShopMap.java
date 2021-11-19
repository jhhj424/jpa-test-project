package com.example.demo.test.domain.around.operation.shop;

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
@DiscriminatorValue(OperationBoardType.Values.NAIL_SHOP)
@Entity
public class OperationBoardNailShopMap extends OperationBoardMap {

    @Id
    private Long id;

    @Column(nullable = false)
    private Long shopId;

    public OperationBoardNailShopMap(Long shopId) {
        super(OperationBoardType.NAIL_SHOP);
        this.shopId = shopId;
    }
}
