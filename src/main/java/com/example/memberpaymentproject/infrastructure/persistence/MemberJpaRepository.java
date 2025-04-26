package com.example.memberpaymentproject.infrastructure.persistence;

import com.example.memberpaymentproject.domain.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
}

