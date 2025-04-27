package com.example.memberpaymentproject.application.service;

import com.example.memberpaymentproject.application.service.dto.CreateMemberDto;
import com.example.memberpaymentproject.domain.manager.MemberLockManager;
import com.example.memberpaymentproject.domain.model.Member;
import com.example.memberpaymentproject.domain.model.MemberInquiryCount;
import com.example.memberpaymentproject.domain.model.Point;
import com.example.memberpaymentproject.domain.repository.MemberInquiryCountRepository;
import com.example.memberpaymentproject.domain.repository.MemberRepository;
import com.example.memberpaymentproject.domain.repository.PointRepository;
import com.example.memberpaymentproject.infrastructure.persistence.SearchSorting;
import com.example.memberpaymentproject.interfaces.presentation.response.SearchMemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberLockManager memberLockManager;
    private final MemberRepository memberRepository;
    private final MemberInquiryCountRepository memberInquiryCountRepository;
    private final PointRepository pointRepository;

    @Transactional
    public void create(CreateMemberDto createMemberDto) {
        Member member = createMemberDto.toMember();
        memberRepository.save(member);

        MemberInquiryCount memberInquiryCount = MemberInquiryCount.builder()
                .inquiryCount(0L)
                .member(member)
                .build();
        memberInquiryCountRepository.save(memberInquiryCount);

        pointRepository.save(new Point(member, 0));
    }

    public Page<SearchMemberResponse> getAllBy(SearchSorting searchSorting, int page) {
        return memberRepository.search(searchSorting, page);
    }


    public SearchMemberResponse updateInquiry(Long memberId) {
        return memberLockManager.updateInquiry(memberId);
    }
}

