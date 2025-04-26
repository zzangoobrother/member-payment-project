package com.example.memberpaymentproject.application.service.dto;

import com.example.memberpaymentproject.domain.model.Member;

public record CreateMemberDto(
        String name
) {
    public Member toMember() {
        return new Member(name, 0L);
    }
}
