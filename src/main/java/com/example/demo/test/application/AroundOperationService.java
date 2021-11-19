package com.example.demo.test.application;


import com.example.demo.test.api.AroundOperationOrderRequest;
import com.example.demo.test.api.AroundOperationRequest;
import com.example.demo.test.api.SearchAroundOperationResponse;
import com.example.demo.test.domain.around.operation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AroundOperationService {

    private final OperationBoardRepository operationBoardRepository;

    public SearchAroundOperationResponse find(Long id) {
        return SearchAroundOperationResponse.from(getOperationBoard(id));
    }

    public List<SearchAroundOperationResponse> findAll(OperationBoardType operationBoardType) {
        return operationBoardRepository.findByTypeAndActiveTrue(operationBoardType)
                .stream()
                .map(SearchAroundOperationResponse::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public void create(AroundOperationRequest aroundOperationRequest) throws ServletException, IOException {
//        List<Long> ids = excelOperationBoardFile.getIdsFromFile(request);
        List<Long> ids = List.of(1L,2L,3L);

        List<OperationBoardMap> operationBoardMaps = OperationBoardMapFactory.create(ids, aroundOperationRequest.getType());
        OperationBoard operationBoard = aroundOperationRequest.toEntity(operationBoardMaps);

        operationBoardRepository.save(operationBoard);
    }

    @Transactional
    public void update(Long id, AroundOperationRequest aroundOperationRequest) throws ServletException, IOException {
//        List<Long> ids = excelOperationBoardFile.getIdsFromFile(request);
        List<Long> ids = List.of(4L,5L,6L);

        List<OperationBoardMap> operationBoardMaps = OperationBoardMapFactory.create(ids, aroundOperationRequest.getType());
        OperationBoard operationBoard = aroundOperationRequest.toEntity(operationBoardMaps);

        getOperationBoard(id).update(operationBoard);
    }

    @Transactional
    public void updateOperationOrder(AroundOperationOrderRequest request) {
        request.getOperationOrders()
                .forEach(operationOrder -> {
                    getOperationBoard(operationOrder.getId()).updateDisplayOrder(operationOrder.getDisplayOrder());
                });
    }

    @Transactional
    public void delete(Long id) {
        OperationBoard operationBoard = getOperationBoard(id);

        operationBoard.updateActiveFalse();
    }

    private OperationBoard getOperationBoard(Long id) {
        return operationBoardRepository.findByIdAndActiveTrue(id)
                .orElseThrow(IllegalArgumentException::new);
    }
}
