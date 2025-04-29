package com.example.memberpaymentproject.infrastructure.persistence;

import com.example.memberpaymentproject.domain.model.MemberCoupon;
import com.example.memberpaymentproject.domain.repository.MemberCouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberCouponRepositoryImpl implements MemberCouponRepository {

    private final MemberCouponJpaRepository repository;

    @Override
    public MemberCoupon save(MemberCoupon memberCoupon) {
        return repository.save(memberCoupon);
    }
}
