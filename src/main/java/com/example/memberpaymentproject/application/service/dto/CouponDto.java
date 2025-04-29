package com.example.memberpaymentproject.application.service.dto;

import com.example.memberpaymentproject.domain.model.Coupon;

public record CouponDto(
        int amount,
        int discountPercent,
        int limitPrice
) {
    public Coupon toCoupon() {
        return Coupon.builder()
                .amount(amount())
                .discountPercent(discountPercent())
                .limitPrice(limitPrice())
                .build();
    }
}
