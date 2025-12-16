package com.example.msorders.repository;

import com.example.msorders.dto.OrderResponseDto;
import com.example.msorders.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    boolean existsByCustomerId(String code);

    boolean existsByPan(String digits);
}
