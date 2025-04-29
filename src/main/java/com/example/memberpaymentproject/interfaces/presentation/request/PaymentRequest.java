package com.example.memberpaymentproject.interfaces.presentation.request;

import com.example.memberpaymentproject.application.event.dto.PaymentDto;

public record PaymentRequest(
        Long memberId,
        Long couponId,
        int amount
) {

    public PaymentDto toPaymentDto() {
        return new PaymentDto(memberId, couponId, amount);
    }
}
