package com.example.msorders.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table (name = "orders")
@RequiredArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "pan")
    private String pan;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "currency")
    private String currency;

    @Column(name = "status")
    private String status = "PENDING";

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
