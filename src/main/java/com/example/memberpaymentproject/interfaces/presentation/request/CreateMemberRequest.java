package com.example.memberpaymentproject.interfaces.presentation.request;

import com.example.memberpaymentproject.application.service.dto.CreateMemberDto;

public record CreateMemberRequest(
        String name
) {
    public CreateMemberDto toCreateMemberDto() {
        return new CreateMemberDto(name());
    }
}
