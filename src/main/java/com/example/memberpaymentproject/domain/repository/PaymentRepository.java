package com.example.memberpaymentproject.domain.repository;

import com.example.memberpaymentproject.domain.model.Payment;

public interface PaymentRepository {

    Payment save(Payment payment);
}
