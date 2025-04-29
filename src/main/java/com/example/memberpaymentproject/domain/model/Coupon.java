package com.example.memberpaymentproject.domain.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "coupon")
@Entity
public class Coupon extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private int amount;

    @Column(name = "discount_percent")
    private int discountPercent;

    @Column(name = "limit_price")
    private int limitPrice;

    @Builder
    public Coupon(int amount, int discountPercent, int limitPrice) {
        this.amount = amount;
        this.discountPercent = discountPercent;
        this.limitPrice = limitPrice;
    }

    public int calculateDiscount(int amount) {
        int discountPrice = amount * getDiscountPercent() / 100;
        System.out.println(discountPrice);
        if (discountPrice > getLimitPrice()) {
            discountPrice = getLimitPrice();
        }
        System.out.println(discountPrice);
        return discountPrice;
    }
}
