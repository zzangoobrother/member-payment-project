package com.example.memberpaymentproject.application.service;

import com.example.memberpaymentproject.domain.model.BusinessType;
import com.example.memberpaymentproject.domain.model.Member;
import com.example.memberpaymentproject.domain.model.Point;
import com.example.memberpaymentproject.domain.model.PointDetails;
import com.example.memberpaymentproject.domain.repository.MemberRepository;
import com.example.memberpaymentproject.domain.repository.PointDetailsRepository;
import com.example.memberpaymentproject.domain.repository.PointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PointService {

    private final MemberRepository memberRepository;
    private final PointRepository pointRepository;
    private final PointDetailsRepository pointDetailsRepository;

    @Transactional
    public void accumulatePoint(Long memberId, int amount) {
        Member member = memberRepository.getByMemberId(memberId);
        Point point = pointRepository.getByMemberWithPessimisticLock(member);
        point.addAmount(amount);

        PointDetails pointDetails = PointDetails.builder()
                .point(point)
                .businessType(BusinessType.ACCUMULATE)
                .balance(amount)
                .build();
        pointDetailsRepository.save(pointDetails);
    }

    public Point getBy(Long pointId) {
        return pointRepository.getBy(pointId);
    }
}
