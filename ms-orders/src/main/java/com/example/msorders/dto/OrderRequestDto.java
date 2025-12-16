package com.example.msorders.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class OrderRequestDto {
     private String customerId;
     private String pan;
     private Double amount;
     private String currency;
}
