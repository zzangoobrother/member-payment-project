package com.example.memberpaymentproject.interfaces.presentation;

import com.example.memberpaymentproject.application.service.MemberService;
import com.example.memberpaymentproject.infrastructure.persistence.SearchSorting;
import com.example.memberpaymentproject.interfaces.presentation.request.CreateMemberRequest;
import com.example.memberpaymentproject.interfaces.presentation.response.SearchMemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class MemberController {

    private final MemberService memberService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/members")
    public void create(@RequestBody CreateMemberRequest request) {
        memberService.create(request.toCreateMemberDto());
    }

    @GetMapping("/members")
    public Page<SearchMemberResponse> getAllBy(@RequestParam SearchSorting searchSorting, @RequestParam int page) {
        return memberService.getAllBy(searchSorting, page);
    }

    @PutMapping("/members/{memberId}/inquiry")
    public SearchMemberResponse updateInquiry(@PathVariable Long memberId) {
        return memberService.updateInquiry(memberId);
    }
}
