package com.example.memberpaymentproject.domain.repository;

import com.example.memberpaymentproject.domain.model.Coupon;

public interface CouponRepository {
    Coupon getBy(Long couponId);

    Coupon save(Coupon coupon);
}
