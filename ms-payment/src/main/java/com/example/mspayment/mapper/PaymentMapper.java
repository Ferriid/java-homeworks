package com.example.mspayment.mapper;

import com.example.mspayment.dto.PaymentRequestDto;
import com.example.mspayment.entity.PaymentEntity;
import com.example.mspayment.uniqueMaker.UniqueMaker;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
@RequiredArgsConstructor
public class PaymentMapper {

    public final UniqueMaker uniqueMaker;
    public PaymentEntity mapRequestDtoToEntity (PaymentRequestDto paymentRequestDto) {
        var paymentEntity = new PaymentEntity();
        paymentEntity.setCustomerId(uniqueMaker.generateUniqueCustomerId());
        paymentEntity.setCurrency(paymentRequestDto.getCurrency());
        paymentEntity.setPan(uniqueMaker.generateUniquePan());
        paymentEntity.setOrderId(paymentRequestDto.getOrderId());
        paymentEntity.setBalance(0.00);
        paymentEntity.setStatus("ACTIVE");
        paymentEntity.setCreatedAt(LocalDateTime.now());
        paymentEntity.setUpdatedAt(LocalDateTime.now());
        return paymentEntity;
    }
}
