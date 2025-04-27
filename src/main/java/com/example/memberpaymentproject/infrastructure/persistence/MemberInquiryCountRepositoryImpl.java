package com.example.memberpaymentproject.infrastructure.persistence;

import com.example.memberpaymentproject.domain.model.MemberInquiryCount;
import com.example.memberpaymentproject.domain.repository.MemberInquiryCountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberInquiryCountRepositoryImpl implements MemberInquiryCountRepository {

    private final MemberInquiryCountJpaRepository repository;

    @Override
    public MemberInquiryCount save(MemberInquiryCount memberInquiryCount) {
        return repository.save(memberInquiryCount);
    }
}
