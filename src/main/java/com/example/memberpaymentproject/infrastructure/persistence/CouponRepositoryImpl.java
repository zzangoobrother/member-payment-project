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
        return repository.findById(couponId).orElse(
                Coupon.builder()
                        .discountPercent(0)
                        .limitPrice(0)
                        .build()
        );
    }

    @Override
    public Coupon save(Coupon coupon) {
        return repository.save(coupon);
    }
}
