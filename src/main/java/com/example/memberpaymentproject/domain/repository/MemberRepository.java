package com.example.memberpaymentproject.domain.repository;

import com.example.memberpaymentproject.domain.model.Member;
import com.example.memberpaymentproject.infrastructure.persistence.SearchSorting;
import com.example.memberpaymentproject.interfaces.presentation.response.SearchMemberResponse;
import org.springframework.data.domain.Page;

public interface MemberRepository {
    Member save(Member member);

    Page<SearchMemberResponse> search(SearchSorting searchSorting, int page);

    Member getByMemberId(Long memberId);
}
