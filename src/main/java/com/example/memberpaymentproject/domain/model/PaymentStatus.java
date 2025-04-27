package com.example.memberpaymentproject.domain.model;

import lombok.Getter;

@Getter
public enum PaymentStatus {
    COMPLETED("결제 완료"),
    CANCEL("결제 취소");

    private String description;

    PaymentStatus(String description) {
        this.description = description;
    }
}
