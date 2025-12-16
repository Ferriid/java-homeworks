package com.example.msorders;
import com.example.msorders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.UUID;
@Service
@RequiredArgsConstructor
public class OrderUnique {
        private final OrderRepository orderRepository;

        public String generateUniqueOrderId() {
            String code;
            do {
                code = UUID.randomUUID()
                        .toString()
                        .replace("-", "")
                        .substring(0, 13)
                        .toUpperCase();
            } while (orderRepository.existsByCustomerId(code));
            return code;
        }

        public String generateUniquePan() {
            String digits;
            do {
                digits = UUID.randomUUID()
                        .toString()
                        .replace("-", "")
                        .replaceAll("[A-Fa-f]", "").substring(0,16);
            } while (orderRepository.existsByPan(digits));
            return digits;
        }
    }

