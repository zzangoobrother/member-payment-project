package com.example.memberpaymentproject.application.event.dto;

import com.example.memberpaymentproject.domain.manager.pay.PayType;
import lombok.Builder;

public record PointDto(
        Long memberId,
        String orderId,
        int amount,
        String paymentKey,
        PayType payType
) {

    @Builder
    public PointDto {}
}
