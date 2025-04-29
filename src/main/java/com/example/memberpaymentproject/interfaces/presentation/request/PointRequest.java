package com.example.memberpaymentproject.interfaces.presentation.request;

import com.example.memberpaymentproject.application.event.dto.PointDto;
import com.example.memberpaymentproject.domain.manager.pay.PayType;

public record PointRequest(
        Long memberId,
        String orderId,
        int amount,
        String paymentKey,
        PayType payType
) {

    public PointDto toPaymentDto() {
        return PointDto.builder()
                .memberId(memberId())
                .orderId(orderId())
                .amount(amount())
                .paymentKey(paymentKey())
                .payType(payType())
                .build();
    }
}
