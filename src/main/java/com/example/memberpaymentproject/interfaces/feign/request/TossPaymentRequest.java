package com.example.memberpaymentproject.interfaces.feign.request;

public record TossPaymentRequest(
        String orderId,
        String amount,
        String paymentKey
) {
}
