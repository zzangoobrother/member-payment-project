package com.example.memberpaymentproject.interfaces.presentation;

import com.example.memberpaymentproject.application.service.MemberService;
import com.example.memberpaymentproject.interfaces.presentation.request.CreateMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public void create(@RequestBody CreateMemberRequest request) {
        memberService.create(request.toCreateMemberDto());
    }
}
