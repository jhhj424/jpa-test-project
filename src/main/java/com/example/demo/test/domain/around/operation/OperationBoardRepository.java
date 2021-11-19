package com.example.demo.test.domain.around.operation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OperationBoardRepository extends JpaRepository<OperationBoard, Long> {

    Optional<OperationBoard> findByIdAndActiveTrue(Long id);

    List<OperationBoard> findByTypeAndActiveTrue(OperationBoardType type);

}
