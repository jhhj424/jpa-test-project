package com.example.demo.test.domain.around.operation;


import com.example.demo.test.domain.around.operation.shop.OperationBoardHairShopMap;
import com.example.demo.test.domain.around.operation.shop.OperationBoardNailShopMap;
import com.example.demo.test.domain.around.operation.styler.OperationBoardStylerMap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class OperationBoardMapFactory {

    public static List<OperationBoardMap> create(List<Long> ids, OperationBoardType operationBoardType) {
        if (operationBoardType == OperationBoardType.HAIR_SHOP) {
            return ids.stream()
                    .map(OperationBoardHairShopMap::new)
                    .collect(Collectors.toList());
        }
        if (operationBoardType == OperationBoardType.NAIL_SHOP) {
            return ids.stream()
                    .map(OperationBoardNailShopMap::new)
                    .collect(Collectors.toList());
        }
        if (operationBoardType == OperationBoardType.STYLER) {
            return ids.stream()
                    .map(OperationBoardStylerMap::new)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
