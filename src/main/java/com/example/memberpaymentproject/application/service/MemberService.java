package com.example.memberpaymentproject.application.service;

import com.example.memberpaymentproject.application.service.dto.CreateMemberDto;
import com.example.memberpaymentproject.domain.model.Member;
import com.example.memberpaymentproject.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public void create(CreateMemberDto createMemberDto) {
        Member member = createMemberDto.toMember();
        memberRepository.save(member);
    }
}

