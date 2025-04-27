package com.example.memberpaymentproject.domain.manager;

import com.example.memberpaymentproject.domain.model.Member;
import com.example.memberpaymentproject.domain.model.MemberInquiryCount;
import com.example.memberpaymentproject.domain.repository.MemberInquiryCountRepository;
import com.example.memberpaymentproject.domain.repository.MemberRepository;
import com.example.memberpaymentproject.interfaces.presentation.response.SearchMemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class MemberManager {

    private final MemberRepository memberRepository;
    private final MemberInquiryCountRepository memberInquiryCountRepository;

    @Transactional
    public SearchMemberResponse updateInquiry(Long memberId) {
        Member member = memberRepository.getByMemberId(memberId);
        MemberInquiryCount memberInquiryCount = memberInquiryCountRepository.getByMember(member);
        memberInquiryCount.addInquiryCount();

        return new SearchMemberResponse(member.getName(), memberInquiryCount.getInquiryCount(), member.getCreatedAt().toString());
    }
}
