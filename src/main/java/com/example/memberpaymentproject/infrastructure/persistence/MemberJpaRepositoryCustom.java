package com.example.memberpaymentproject.infrastructure.persistence;

import org.springframework.data.domain.Page;

public interface MemberJpaRepositoryCustom {

    Page search(SearchSorting searchSorting, int page);
}
