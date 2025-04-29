package com.example.memberpaymentproject.interfaces.presentation;

import com.example.memberpaymentproject.application.service.PaymentService;
import com.example.memberpaymentproject.interfaces.presentation.request.PointRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class PointController {

    private final PaymentService paymentService;

    @PostMapping("/point/load")
    public void pointLoadPayment(@RequestBody PointRequest request) {
        paymentService.pointLoadPayment(request.toPaymentDto());
    }
}
