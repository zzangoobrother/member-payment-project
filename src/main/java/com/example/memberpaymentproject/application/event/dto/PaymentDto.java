package com.example.memberpaymentproject.application.event.dto;

public record PaymentDto(
        Long memberId,
        Long couponId,
        int amount
) {
}
