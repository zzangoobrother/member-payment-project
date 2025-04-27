package com.example.memberpaymentproject.acceptance;

import com.example.memberpaymentproject.infrastructure.persistence.SearchSorting;
import com.example.memberpaymentproject.interfaces.presentation.request.CreateMemberRequest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.example.memberpaymentproject.acceptance.MemberSteps.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class MemberAcceptanceTest extends AcceptanceTest {

    @Test
    void 프로필_업데이트_2개() {
        CreateMemberRequest request = new CreateMemberRequest("가나다");
        회원_등록(request);

        CompletableFuture.allOf(
                CompletableFuture.runAsync(() -> 회원_프로필_업데이트(1L)),
                CompletableFuture.runAsync(() -> 회원_프로필_업데이트(1L))
        ).join();

        ExtractableResponse<Response> response = 회원_목록_조회(SearchSorting.NAME, 0);

        List<String> names = response.jsonPath().getList("content.name");
        List<Integer> inquiryCounts = response.jsonPath().getList("content.inquiryCount");

        assertAll(
                () -> assertThat(names).containsExactly("가나다"),
                () -> assertThat(inquiryCounts).containsExactly(2)
        );
    }

    @Test
    void 프로필_업데이트_10개() {
        CreateMemberRequest request = new CreateMemberRequest("가나다");
        회원_등록(request);

        CompletableFuture.allOf(
                CompletableFuture.runAsync(() -> 회원_프로필_업데이트(1L)),
                CompletableFuture.runAsync(() -> 회원_프로필_업데이트(1L)),
                CompletableFuture.runAsync(() -> 회원_프로필_업데이트(1L)),
                CompletableFuture.runAsync(() -> 회원_프로필_업데이트(1L)),
                CompletableFuture.runAsync(() -> 회원_프로필_업데이트(1L)),
                CompletableFuture.runAsync(() -> 회원_프로필_업데이트(1L)),
                CompletableFuture.runAsync(() -> 회원_프로필_업데이트(1L)),
                CompletableFuture.runAsync(() -> 회원_프로필_업데이트(1L)),
                CompletableFuture.runAsync(() -> 회원_프로필_업데이트(1L)),
                CompletableFuture.runAsync(() -> 회원_프로필_업데이트(1L))
        ).join();

        ExtractableResponse<Response> response = 회원_목록_조회(SearchSorting.NAME, 0);

        List<String> names = response.jsonPath().getList("content.name");
        List<Integer> inquiryCounts = response.jsonPath().getList("content.inquiryCount");

        assertAll(
                () -> assertThat(names).containsExactly("가나다"),
                () -> assertThat(inquiryCounts).containsExactly(10)
        );
    }
}
