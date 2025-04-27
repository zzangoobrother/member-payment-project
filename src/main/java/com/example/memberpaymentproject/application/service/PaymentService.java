package com.example.memberpaymentproject.application.service;

import com.example.memberpaymentproject.global.properties.PaymentProperties;
import com.example.memberpaymentproject.interfaces.feign.PaymentClient;
import com.example.memberpaymentproject.interfaces.feign.request.TossPaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RequiredArgsConstructor
@Service
public class PaymentService {

    private final PaymentProperties paymentProperties;
    private final PaymentClient paymentClient;

    public void payment(Long memberId, Long orderId, int amount, String paymentKey) {
        String widgetSecretKey = paymentProperties.toss();

        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode((widgetSecretKey + ":").getBytes(StandardCharsets.UTF_8));
        String authorizations = "Basic " + new String(encodedBytes);

        paymentClient.payment(authorizations, new TossPaymentRequest(String.valueOf(orderId), String.valueOf(amount), paymentKey));
    }
}
