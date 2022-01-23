package com.example.demo.test.domain.around.operation;

import com.example.demo.test.domain.around.operation.shop.Shop;
import com.example.demo.test.domain.around.operation.styler.Styler;
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
@DiscriminatorValue(OperationBoardType.Values.STYLER)
@Entity
public class OperationBoardStyler extends OperationBoard {

    @ManyToMany
    @org.hibernate.annotations.ForeignKey(name = "none")
    @JoinTable(name="operation_board_styler_map",
            joinColumns = @JoinColumn(name = "operation_board_id"),
            inverseJoinColumns = @JoinColumn( name = "styler_id"))
    private Set<Styler> stylers;
}
