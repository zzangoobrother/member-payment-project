package com.example.memberpaymentproject.application.event.dto;

public record CreatePointDto(
        Long memberId,
        int amount
) {
}
