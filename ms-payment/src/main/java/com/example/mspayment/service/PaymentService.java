package com.example.mspayment.service;


import com.example.mspayment.dto.PaymentRequestDto;
import com.example.mspayment.dto.PaymentResponseDto;
import com.example.mspayment.entity.PaymentEntity;
import com.example.mspayment.mapper.PaymentMapper;
import com.example.mspayment.repository.PaymentRepository;
import com.example.mspayment.uniqueMaker.UniqueMaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class PaymentService {
    public final PaymentMapper paymentMapper;
    public final PaymentRepository paymentRepository;

    public void addNewBankCustomer (PaymentRequestDto paymentRequestDto) {
        var paymentEntity =  paymentMapper.mapRequestDtoToEntity(paymentRequestDto);
        paymentRepository.save(paymentEntity);
    }


    public boolean enoughAmountInBalance (PaymentResponseDto paymentResponseDto) {
        var id = paymentResponseDto.getCustomerId();
        var amount = paymentResponseDto.getAmount();
       var entity = paymentRepository.getByCustomerId(id);
        if (amount > entity.getBalance() ) {
return false;
        }
        else  {
            PaymentEntity paymentEntity = paymentRepository.getByCustomerId(id);
            paymentEntity.setBalance(entity.getBalance() - amount);
            paymentRepository.save(paymentEntity);
            return true;
        }
    }
}
