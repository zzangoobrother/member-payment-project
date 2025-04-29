package com.example.memberpaymentproject.interfaces.presentation;

import com.example.memberpaymentproject.application.service.CouponService;
import com.example.memberpaymentproject.interfaces.presentation.request.CouponRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class CouponController {

    private final CouponService couponService;

    @PostMapping("/coupons")
    public void create(@RequestBody CouponRequest request) {
        couponService.create(request.toCouponDto());
    }
}
