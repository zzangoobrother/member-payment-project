package com.example.memberpaymentproject.application.service;

import com.example.memberpaymentproject.application.event.dto.AccumulatePointDto;
import com.example.memberpaymentproject.application.event.dto.PointDto;
import com.example.memberpaymentproject.domain.manager.PayManager;
import com.example.memberpaymentproject.domain.manager.pay.PayType;
import com.example.memberpaymentproject.domain.model.Member;
import com.example.memberpaymentproject.domain.model.Payment;
import com.example.memberpaymentproject.domain.model.PaymentStatus;
import com.example.memberpaymentproject.domain.repository.MemberRepository;
import com.example.memberpaymentproject.domain.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PaymentService {

    private final ApplicationEventPublisher publisher;
    private final List<PayManager> payManagers;
    private final MemberRepository memberRepository;
    private final PaymentRepository paymentRepository;

    @Transactional
    public void pointLoadPayment(PointDto pointDto) {
        Long memberId = pointDto.memberId();
        PayType payType = pointDto.payType();
        String orderId = pointDto.orderId();
        int amount = pointDto.amount();
        String paymentKey = pointDto.paymentKey();

        Member member = memberRepository.getByMemberId(memberId);

        PayManager payManager = payManagers.stream()
                .filter(it -> it.supports(payType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(""));

        String method = payManager.payment(orderId, amount, paymentKey);

        Payment payment = Payment.builder()
                .member(member)
                .orderId(orderId)
                .amount(amount)
                .paymentMethod(method)
                .paymentStatus(PaymentStatus.COMPLETED)
                .build();
        paymentRepository.save(payment);

        publisher.publishEvent(new AccumulatePointDto(memberId, amount));
    }
}
