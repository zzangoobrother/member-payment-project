package com.example.memberpaymentproject.application.service;

import com.example.memberpaymentproject.application.event.dto.AccumulatePointDto;
import com.example.memberpaymentproject.domain.model.Member;
import com.example.memberpaymentproject.domain.model.Payment;
import com.example.memberpaymentproject.domain.model.PaymentStatus;
import com.example.memberpaymentproject.domain.repository.MemberRepository;
import com.example.memberpaymentproject.domain.repository.PaymentRepository;
import com.example.memberpaymentproject.global.properties.PaymentProperties;
import com.example.memberpaymentproject.interfaces.feign.PaymentClient;
import com.example.memberpaymentproject.interfaces.feign.request.TossPaymentRequest;
import com.example.memberpaymentproject.interfaces.feign.response.TossPaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RequiredArgsConstructor
@Service
public class PaymentService {

    private final ApplicationEventPublisher publisher;
    private final PaymentProperties paymentProperties;
    private final PaymentClient paymentClient;
    private final MemberRepository memberRepository;
    private final PaymentRepository paymentRepository;

    @Transactional
    public void payment(Long memberId, String orderId, int amount, String paymentKey) {
        Member member = memberRepository.getByMemberId(memberId);

        String widgetSecretKey = paymentProperties.toss();

        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode((widgetSecretKey + ":").getBytes(StandardCharsets.UTF_8));
        String authorizations = "Basic " + new String(encodedBytes);

        TossPaymentResponse response = paymentClient.payment(authorizations, new TossPaymentRequest(orderId, String.valueOf(amount), paymentKey));

        Payment payment = Payment.builder()
                .member(member)
                .orderId(orderId)
                .amount(amount)
                .paymentMethod(response.method())
                .paymentStatus(PaymentStatus.COMPLETED)
                .build();
        paymentRepository.save(payment);

        publisher.publishEvent(new AccumulatePointDto(memberId, amount));
    }
}
