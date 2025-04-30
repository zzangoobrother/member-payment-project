package com.example.memberpaymentproject.application.service;

import com.example.memberpaymentproject.application.event.dto.AccumulatePointDto;
import com.example.memberpaymentproject.application.event.dto.PaymentDto;
import com.example.memberpaymentproject.application.event.dto.PointDto;
import com.example.memberpaymentproject.domain.manager.PayManager;
import com.example.memberpaymentproject.domain.manager.pay.PayType;
import com.example.memberpaymentproject.domain.model.*;
import com.example.memberpaymentproject.domain.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class PaymentService {

    private final ApplicationEventPublisher publisher;
    private final List<PayManager> payManagers;
    private final MemberRepository memberRepository;
    private final CouponRepository couponRepository;
    private final MemberCouponRepository memberCouponRepository;
    private final PaymentRepository paymentRepository;
    private final PointRepository pointRepository;
    private final PointDetailsRepository pointDetailsRepository;

    @Transactional
    public void pointLoadPayment(PointDto pointDto) {
        Long memberId = pointDto.memberId();
        PayType payType = pointDto.payType();
        String orderId = pointDto.orderId();
        int amount = pointDto.amount();
        String paymentKey = pointDto.paymentKey();

        Member member = getByMemberId(memberId);

        PayManager payManager = payManagers.stream()
                .filter(it -> it.supports(payType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("결제 방식을 선택해주세요."));

        String method = payManager.payment(orderId, amount, paymentKey);

        Payment payment = pointDto.toPayment(member, method);
        paymentRepository.save(payment);

        publisher.publishEvent(new AccumulatePointDto(memberId, amount));
    }

    @Transactional
    public void payment(PaymentDto paymentDto) {
        Member member = getByMemberId(paymentDto.memberId());

        int amount = paymentDto.amount();
        if (!Objects.isNull(paymentDto.couponId())) {
            Coupon coupon = couponRepository.getBy(paymentDto.couponId());
            int discountAmount = coupon.calculateDiscount(amount);

            amount = amount - discountAmount;

            memberCouponRepository.save(new MemberCoupon(member, coupon));
        }

        Point point = pointRepository.getByMember(member);
        if (point.getAmount() < amount) {
            throw new IllegalArgumentException("포인트 잔액이 부족합니다.");
        }

        point.payment(amount);

        PointDetails pointDetails = PointDetails.builder()
                .point(point)
                .businessType(BusinessType.USED)
                .balance(amount)
                .build();
        pointDetailsRepository.save(pointDetails);
    }

    private Member getByMemberId(Long memberId) {
        return memberRepository.getByMemberId(memberId);
    }
}
