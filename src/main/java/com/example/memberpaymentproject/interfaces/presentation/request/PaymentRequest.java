package com.example.memberpaymentproject.interfaces.presentation.request;

public record PaymentRequest(
        Long memberId,
        String orderId,
        int amount,
        String paymentKey
) {
}
