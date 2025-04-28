package com.example.memberpaymentproject.domain.manager;

import com.example.memberpaymentproject.domain.manager.pay.PayType;

public interface PayManager {
    boolean supports(PayType payType);

    String payment(String orderId, int amount, String paymentKey);
}
