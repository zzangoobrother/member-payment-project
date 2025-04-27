package com.example.memberpaymentproject.infrastructure.persistence;

import com.example.memberpaymentproject.domain.model.Payment;
import com.example.memberpaymentproject.domain.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
class PaymentRepositoryImpl implements PaymentRepository {

    private final PaymentJpaRepository repository;

    @Override
    public Payment save(Payment payment) {
        return repository.save(payment);
    }
}
