package com.example.demo.test.domain.around.operation;

import com.example.demo.test.domain.around.operation.shop.Shop;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue(OperationBoardType.Values.NAIL_SHOP)
@Entity
public class OperationBoardNailShop extends OperationBoard {

    @ManyToMany
    @org.hibernate.annotations.ForeignKey(name = "none")
    @JoinTable(name="operation_board_nail_shop_map",
            joinColumns = @JoinColumn(name = "operation_board_id"),
            inverseJoinColumns = @JoinColumn( name = "shop_id"))
    private Set<Shop> shops;
}
