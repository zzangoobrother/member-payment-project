package com.example.memberpaymentproject.application.event.dto;

public record AccumulatePointDto(
        Long memberId,
        int amount
) {
}
