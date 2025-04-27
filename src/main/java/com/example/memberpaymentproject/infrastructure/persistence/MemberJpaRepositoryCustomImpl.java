package com.example.memberpaymentproject.infrastructure.persistence;

import com.example.memberpaymentproject.interfaces.presentation.response.QSearchMemberResponse;
import com.example.memberpaymentproject.interfaces.presentation.response.SearchMemberResponse;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.memberpaymentproject.domain.model.QMember.member;
import static com.example.memberpaymentproject.domain.model.QMemberInquiryCount.memberInquiryCount;

@RequiredArgsConstructor
@Repository
public class MemberJpaRepositoryCustomImpl implements MemberJpaRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<SearchMemberResponse> search(SearchSorting searchSorting, int page) {
        PageRequest pageRequest = PageRequest.of(page, 10);
        List<SearchMemberResponse> content = queryFactory.select(new QSearchMemberResponse(
                        member.name,
                        memberInquiryCount.inquiryCount,
                        member.createdAt.stringValue()
                ))
                .from(member)
                .leftJoin(memberInquiryCount)
                .on(member.eq(memberInquiryCount.member))
                .orderBy(sorting(searchSorting))
                .offset(pageRequest.getOffset())
                .limit(pageRequest.getPageSize())
                .fetch();

        Long count = queryFactory.select(member.count())
                .from(member)
                .leftJoin(memberInquiryCount)
                .on(member.eq(memberInquiryCount.member))
                .fetchOne();

        return new PageImpl<>(content, pageRequest, count);
    }

    private OrderSpecifier<?> sorting(SearchSorting searchSorting) {
        if (searchSorting == SearchSorting.NAME) {
            return member.name.asc();
        }

        if (searchSorting == SearchSorting.INQUIRY) {
            return memberInquiryCount.inquiryCount.desc();
        }

        return member.createdAt.desc();
    }
}
