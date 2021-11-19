package com.example.demo.test.domain.around.operation.shop;

import com.example.demo.test.domain.around.operation.OperationBoardMap;
import com.example.demo.test.domain.around.operation.OperationBoardType;
import lombok.*;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue(OperationBoardType.Values.HAIR_SHOP)
@Entity
public class OperationBoardHairShopMap extends OperationBoardMap {

    @Id
    private Long id;

    @Column(nullable = false)
    private Long shopId;

    public OperationBoardHairShopMap(Long shopId) {
        super(OperationBoardType.HAIR_SHOP);
        this.shopId = shopId;
    }
}
