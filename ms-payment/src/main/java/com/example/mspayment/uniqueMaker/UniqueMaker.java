package com.example.mspayment.uniqueMaker;

import com.example.mspayment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class UniqueMaker {

    private final PaymentRepository paymentRepository;

    public String generateUniqueCustomerId() {
        String code;
        do {
            code = UUID.randomUUID()
                    .toString()
                    .replace("-", "")
                    .substring(0, 7)
                    .toUpperCase();
        } while (paymentRepository.existsByCustomerId(code));
        return code;
    }

    public String generateUniquePan() {
        String digits;
        do {
            digits = UUID.randomUUID()
                    .toString()
                    .replace("-", "")
                    .replaceAll("[A-Fa-f]", "").substring(0,16);
        } while (paymentRepository.existsByPan(digits));
        return digits;
    }
}