package com.example.memberpaymentproject.domain.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member_inquiry_count")
@Entity
public class MemberInquiryCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "inquiry_count")
    private Long inquiryCount;

    @Builder
    public MemberInquiryCount(Member member, Long inquiryCount) {
        this.member = member;
        this.inquiryCount = inquiryCount;
    }
}
