package com.example.mspayment.repository;

import com.example.mspayment.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository <PaymentEntity,Long> {
    boolean existsByCustomerId(String customerId);

    boolean existsByPan(String pan);

    PaymentEntity getByCustomerId(String customerId);
}
