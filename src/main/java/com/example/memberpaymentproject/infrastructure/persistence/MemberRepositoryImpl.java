package com.example.memberpaymentproject.infrastructure.persistence;

import com.example.memberpaymentproject.domain.model.Member;
import com.example.memberpaymentproject.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository repository;

    @Override
    public Member save(Member member) {
        return repository.save(member);
    }
}
