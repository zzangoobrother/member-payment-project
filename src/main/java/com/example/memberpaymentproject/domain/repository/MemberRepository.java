package com.example.memberpaymentproject.domain.repository;

import com.example.memberpaymentproject.domain.model.Member;

public interface MemberRepository {
    Member save(Member member);
}
