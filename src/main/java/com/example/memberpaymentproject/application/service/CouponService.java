package com.example.memberpaymentproject.application.service;

import com.example.memberpaymentproject.application.service.dto.CouponDto;
import com.example.memberpaymentproject.domain.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CouponService {

    private final CouponRepository couponRepository;

    public void create(CouponDto couponDto) {
        couponRepository.save(couponDto.toCoupon());
    }
}
