package com.example.memberpaymentproject.infrastructure.persistence;

import com.example.memberpaymentproject.domain.model.Member;
import com.example.memberpaymentproject.domain.repository.MemberRepository;
import com.example.memberpaymentproject.interfaces.presentation.response.SearchMemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository repository;

    @Override
    public Member save(Member member) {
        return repository.save(member);
    }

    @Override
    public Page<SearchMemberResponse> search(SearchSorting searchSorting, int page) {
        return repository.search(searchSorting, page);
    }

    @Override
    public Member getByMemberId(Long memberId) {
        return repository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("해당 회원이 존재하지 않습니다.")
        );
    }
}
