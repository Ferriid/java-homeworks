package com.example.mspayment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class PaymentRequestDto {
    private String customerId;
    private String pan;
    private String currency;
    private String orderId;
}
