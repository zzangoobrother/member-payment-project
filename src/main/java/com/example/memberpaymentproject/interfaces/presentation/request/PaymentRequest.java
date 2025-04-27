package com.example.memberpaymentproject.interfaces.presentation.request;

public record PaymentRequest(
        Long memberId,
        Long orderId,
        int amount,
        String paymentKey
) {
}
