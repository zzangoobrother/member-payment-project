package com.example.memberpaymentproject.interfaces.feign;

import com.example.memberpaymentproject.global.exception.feign.PaymentFeignClientErrorDecoder;
import com.example.memberpaymentproject.interfaces.feign.request.TossPaymentRequest;
import com.example.memberpaymentproject.interfaces.feign.response.TossPaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "paymentClient", url = "https://api.tosspayments.com/v1", configuration = PaymentFeignClientErrorDecoder.class)
public interface PaymentClient {

    @PostMapping(value = "/payments/confirm", consumes = "application/json; charset=UTF-8")
    TossPaymentResponse payment(@RequestHeader("Authorization") String authorization, @RequestBody TossPaymentRequest request);
}
