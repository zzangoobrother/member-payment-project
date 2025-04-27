package com.example.memberpaymentproject.domain.model;

public enum BusinessType {

    ACCUMULATE("충전"),
    USED("사용"),
    CANCEL("취소");

    private final String value;

    BusinessType(String value) {
        this.value = value;
    }
}
