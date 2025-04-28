package com.example.memberpaymentproject.interfaces.presentation.request;

import com.example.memberpaymentproject.domain.manager.pay.PayType;

public record PaymentRequest(
        Long memberId,
        String orderId,
        int amount,
        String paymentKey,
        PayType payType
) {
}
