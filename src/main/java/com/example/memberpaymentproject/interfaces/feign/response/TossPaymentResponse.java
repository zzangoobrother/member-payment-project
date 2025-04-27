package com.example.memberpaymentproject.interfaces.feign.response;

public record TossPaymentResponse(
        String orderId,
        String method
) {
}
