package com.example.memberpaymentproject.infrastructure.persistence;

import com.example.memberpaymentproject.domain.model.Member;
import com.example.memberpaymentproject.domain.model.MemberInquiryCount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberInquiryCountJpaRepository extends JpaRepository<MemberInquiryCount, Long> {

    Optional<MemberInquiryCount> findByMember(Member member);
}
