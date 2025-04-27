package com.example.memberpaymentproject.domain.repository;

import com.example.memberpaymentproject.domain.model.Member;
import com.example.memberpaymentproject.domain.model.MemberInquiryCount;

public interface MemberInquiryCountRepository {

    MemberInquiryCount save(MemberInquiryCount memberInquiryCount);

    MemberInquiryCount getByMember(Member member);
}
