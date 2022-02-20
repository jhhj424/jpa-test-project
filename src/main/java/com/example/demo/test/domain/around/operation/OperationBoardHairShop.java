package com.example.demo.test.domain.around.operation;

import com.example.demo.test.domain.around.operation.shop.Shop;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue(OperationBoardType.Values.HAIR_SHOP)
@Entity
public class OperationBoardHairShop extends OperationBoard {

    @ManyToMany
    @org.hibernate.annotations.ForeignKey(name = "none")
    @JoinTable(name="operation_board_hair_shop_map",
            joinColumns = @JoinColumn(name = "operation_board_id"),
            inverseJoinColumns = @JoinColumn( name = "shop_id"))
    private Set<Shop> shops;

    @Builder
    public OperationBoardHairShop(OperationBoardType type, String title, boolean active, LocalDateTime startDateTime, LocalDateTime endDateTime, int displayOrder, String code, Set<Shop> shops) {
        super(null, type, title, active, startDateTime, endDateTime, displayOrder, "INIT_CODE");
        this.shops = shops;
    }
}
