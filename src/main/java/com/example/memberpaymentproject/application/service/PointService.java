package com.example.memberpaymentproject.application.service;

import com.example.memberpaymentproject.domain.model.Member;
import com.example.memberpaymentproject.domain.model.Point;
import com.example.memberpaymentproject.domain.repository.MemberRepository;
import com.example.memberpaymentproject.domain.repository.PointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PointService {

    private final MemberRepository memberRepository;
    private final PointRepository pointRepository;

    @Transactional
    public void createPoint(Long memberId, int amount) {
        Member member = memberRepository.getByMemberId(memberId);
        Point point = pointRepository.getByMember(member);
        point.addAmount(amount);
    }
}
