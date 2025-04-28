package com.example.memberpaymentproject.domain.manager.pay;

import com.example.memberpaymentproject.domain.manager.PayManager;
import com.example.memberpaymentproject.global.properties.TossPaymentProperties;
import com.example.memberpaymentproject.interfaces.feign.PaymentClient;
import com.example.memberpaymentproject.interfaces.feign.request.TossPaymentRequest;
import com.example.memberpaymentproject.interfaces.feign.response.TossPaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RequiredArgsConstructor
@Component
class TossPayManager implements PayManager {

    private final TossPaymentProperties paymentProperties;
    private final PaymentClient paymentClient;

    @Override
    public boolean supports(PayType payType) {
        return PayType.TOSS_PAY == payType;
    }

    @Override
    public String payment(String orderId, int amount, String paymentKey) {
        String widgetSecretKey = paymentProperties.toss();

        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode((widgetSecretKey + ":").getBytes(StandardCharsets.UTF_8));
        String authorizations = "Basic " + new String(encodedBytes);

        TossPaymentResponse response = paymentClient.payment(authorizations, new TossPaymentRequest(orderId, String.valueOf(amount), paymentKey));

        return response.method();
    }
}
