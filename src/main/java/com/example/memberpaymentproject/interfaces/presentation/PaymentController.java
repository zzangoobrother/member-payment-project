package com.example.memberpaymentproject.interfaces.presentation;

import com.example.memberpaymentproject.application.service.PaymentService;
import com.example.memberpaymentproject.interfaces.presentation.request.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/payments")
    public void payment(@RequestBody PaymentRequest request) {
        paymentService.payment(request.memberId(), request.orderId(), request.amount(), request.paymentKey(), request.payType());
    }
}
