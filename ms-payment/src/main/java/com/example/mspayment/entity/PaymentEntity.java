package com.example.mspayment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "Payments")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "pan")
    private String pan;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "currency")
    private String currency;

    @Column(name = "status")
    private String status;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
