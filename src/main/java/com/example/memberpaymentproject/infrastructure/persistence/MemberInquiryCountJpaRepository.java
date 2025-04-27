package com.example.memberpaymentproject.infrastructure.persistence;

import com.example.memberpaymentproject.domain.model.MemberInquiryCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberInquiryCountJpaRepository extends JpaRepository<MemberInquiryCount, Long> {
}
