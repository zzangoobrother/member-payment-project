package com.example.memberpaymentproject.global.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "payment.secret-key.port-one")
public record PortOnePaymentProperties(
        String apiKey,
        String secretKey
) {
}
