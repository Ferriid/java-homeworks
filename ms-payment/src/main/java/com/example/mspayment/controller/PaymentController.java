package com.example.mspayment.controller;


import com.example.mspayment.dto.PaymentRequestDto;
import com.example.mspayment.dto.PaymentResponseDto;
import com.example.mspayment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public void createNewCustomer(@RequestBody PaymentRequestDto paymentRequestDto) {
        paymentService.addNewBankCustomer(paymentRequestDto);
    }
 @GetMapping("/get")
    public boolean getOrderFromCustomer (@RequestBody PaymentResponseDto paymentResponseDto) {
     return paymentService.enoughAmountInBalance(paymentResponseDto);
 }

}
