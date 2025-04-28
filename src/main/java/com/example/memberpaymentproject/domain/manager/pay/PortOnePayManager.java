package com.example.memberpaymentproject.domain.manager.pay;

import com.example.memberpaymentproject.domain.manager.PayManager;
import com.example.memberpaymentproject.global.properties.PortOnePaymentProperties;
import com.siot.IamportRestClient.IamportClient;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PortOnePayManager implements PayManager {

    private final PortOnePaymentProperties paymentProperties;
    private IamportClient iamportClient;

    @PostConstruct
    public void init() {
        this.iamportClient = new IamportClient(paymentProperties.apiKey(), paymentProperties.secretKey());
    }

    @Override
    public boolean supports(PayType payType) {
        return PayType.PORT_ONE_PAY == payType;
    }

    @Override
    public String payment(String orderId, int amount, String paymentKey) {
        // TODO: port-one 결제하기
        return "";
    }
}
