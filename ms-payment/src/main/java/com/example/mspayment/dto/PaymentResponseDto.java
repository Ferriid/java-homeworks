package com.example.mspayment.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PaymentResponseDto {
    private String customerId;
    private Double amount;
}