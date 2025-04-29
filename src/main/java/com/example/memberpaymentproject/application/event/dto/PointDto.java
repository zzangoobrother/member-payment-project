package com.example.memberpaymentproject.application.event.dto;

import com.example.memberpaymentproject.domain.manager.pay.PayType;
import com.example.memberpaymentproject.domain.model.Member;
import com.example.memberpaymentproject.domain.model.Payment;
import com.example.memberpaymentproject.domain.model.PaymentStatus;
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

    public Payment toPayment(Member member, String method) {
        return Payment.builder()
                .member(member)
                .orderId(orderId)
                .amount(amount)
                .paymentMethod(method)
                .paymentStatus(PaymentStatus.COMPLETED)
                .build();
    }
}
