package com.example.memberpaymentproject.interfaces.presentation.request;

import com.example.memberpaymentproject.application.service.dto.CouponDto;

public record CouponRequest(
        int amount,
        int discountPercent,
        int limitPrice
) {

    public CouponDto toCouponDto() {
        return new CouponDto(amount(), discountPercent(), limitPrice());
    }
}
