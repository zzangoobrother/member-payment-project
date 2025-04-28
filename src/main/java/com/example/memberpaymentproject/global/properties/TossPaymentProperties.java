package com.example.memberpaymentproject.global.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "payment.secret-key")
public record TossPaymentProperties(
        String toss
) {
}
