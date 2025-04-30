package com.example.memberpaymentproject.infrastructure.persistence;

import com.example.memberpaymentproject.domain.model.Coupon;
import com.example.memberpaymentproject.domain.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CouponRepositoryImpl implements CouponRepository {

    private final CouponJpaRepository repository;

    @Override
    public Coupon getBy(Long couponId) {
        return repository.findById(couponId).orElseThrow(
            () -> new IllegalArgumentException("해당 쿠폰을 찾을 수 없습니다.")
        );
    }

    @Override
    public Coupon save(Coupon coupon) {
        return repository.save(coupon);
    }
}
