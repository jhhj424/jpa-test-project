package com.example.demo.test.api;

import com.example.demo.test.application.AroundOperationService;
import com.example.demo.test.domain.around.operation.OperationBoardType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AroundOperationController {

    private final AroundOperationService aroundOperationService;

    @PostMapping("/api/search/around/operations")
    public ResponseEntity create(@RequestBody AroundOperationRequest aroundOperationRequest) throws ServletException, IOException {
        aroundOperationService.create(aroundOperationRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
//
//    @GetMapping("/api/search/around/operations/{id}")
//    public ResponseEntity<SearchAroundOperationResponse> find(@PathVariable Long id) {
//        return ResponseEntity.ok(aroundOperationService.find(id));
//    }

    @GetMapping("/api/search/around/operations")
    public ResponseEntity<List<SearchAroundOperationResponse>> findAll(@RequestParam("operationBoardType") OperationBoardType operationBoardType) {
        return ResponseEntity.ok(aroundOperationService.findAll(operationBoardType));
    }

//    @PutMapping("/api/search/around/operations/{id}")
//    public ResponseEntity update(@PathVariable Long id, @RequestBody AroundOperationRequest searchAroundTabRequest) throws ServletException, IOException {
//        aroundOperationService.update(id, searchAroundTabRequest);
//        return ResponseEntity.ok().build();
//    }
//
//    @PutMapping("/api/search/around/operations/display-orders")
//    public ResponseEntity update(@RequestBody AroundOperationOrderRequest requests) {
//        aroundOperationService.updateOperationOrder(requests);
//        return ResponseEntity.ok().build();
//    }
//
//    @DeleteMapping("/api/search/around/operations/{id}")
//    public ResponseEntity delete(@PathVariable Long id) {
//        aroundOperationService.delete(id);
//
//        return ResponseEntity.noContent().build();
//    }
}
