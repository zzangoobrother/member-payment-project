package com.example.memberpaymentproject.interfaces.presentation.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;

public record SearchMemberResponse(
        String name,
        long inquiryCount,
        String joinDate
) {

    @Builder
    @QueryProjection
    public SearchMemberResponse {}
}
