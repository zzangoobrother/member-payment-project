package com.example.memberpaymentproject.infrastructure.persistence;

import com.example.memberpaymentproject.domain.model.Member;
import com.example.memberpaymentproject.domain.model.MemberInquiryCount;
import com.example.memberpaymentproject.domain.repository.MemberInquiryCountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
class MemberInquiryCountRepositoryImpl implements MemberInquiryCountRepository {

    private final MemberInquiryCountJpaRepository repository;

    @Override
    public MemberInquiryCount save(MemberInquiryCount memberInquiryCount) {
        return repository.save(memberInquiryCount);
    }

    @Override
    public MemberInquiryCount getByMember(Member member) {
        return repository.findByMember(member).orElseThrow(
                () -> new IllegalArgumentException("해당 회원을 찾을 수 없습니다.")
        );
    }
}
