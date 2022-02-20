package com.example.demo.test.application;

import com.example.demo.test.api.AroundOperationRequest;
import com.example.demo.test.domain.around.operation.OperationBoard;
import com.example.demo.test.domain.around.operation.OperationBoardHairShop;
import com.example.demo.test.domain.around.operation.shop.Shop;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.example.demo.test.domain.around.operation.OperationBoardType.*;

public class OperationBoardFactory {

    public static OperationBoard create(List<Long> ids, AroundOperationRequest aroundOperationRequest) {
        if (aroundOperationRequest.getType() == HAIR_SHOP) {
            Set<Shop> shops = Set.of(new Shop(1L), new Shop(5L), new Shop(10L));
            return OperationBoardHairShop.builder()
                    .title(aroundOperationRequest.getTitle())
                    .startDateTime(LocalDateTime.now())
                    .endDateTime(LocalDateTime.now())
                    .displayOrder(aroundOperationRequest.getDisplayOrder())
                    .type(aroundOperationRequest.getType())
                    .active(true)
                    .shops(shops)
                    .build();
        }
        if (aroundOperationRequest.getType() == NAIL_SHOP) {
            return ids.stream()
                    .map(OperationBoardNailShopMap::new)
                    .collect(Collectors.toList());
        }
        if (aroundOperationRequest.getType() == STYLER) {
            return ids.stream()
                    .map(OperationBoardStylerMap::new)
                    .collect(Collectors.toList());
        }
        throw new IllegalArgumentException();
    }
}
