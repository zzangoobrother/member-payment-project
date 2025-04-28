package com.example.memberpaymentproject.acceptance;

import com.example.memberpaymentproject.application.service.PointService;
import com.example.memberpaymentproject.domain.model.Point;
import com.example.memberpaymentproject.interfaces.presentation.request.CreateMemberRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CompletableFuture;

import static com.example.memberpaymentproject.acceptance.MemberSteps.회원_등록;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PointAcceptanceTest extends AcceptanceTest {

    @Autowired
    private PointService pointService;

    @Test
    void 포인트_적립_2개() {
        CreateMemberRequest request = new CreateMemberRequest("가나다");
        회원_등록(request);

        CompletableFuture.allOf(
                CompletableFuture.runAsync(() -> pointService.accumulatePoint(1L, 1000)),
                CompletableFuture.runAsync(() -> pointService.accumulatePoint(1L, 1000))
        ).join();

        Point point = pointService.getBy(1L);

        assertAll(
                () -> assertThat(point.getAmount()).isEqualTo(2000)
        );
    }

    @Test
    void 포인트_적립_10개() {
        CreateMemberRequest request = new CreateMemberRequest("가나다");
        회원_등록(request);

        CompletableFuture.allOf(
                CompletableFuture.runAsync(() -> pointService.accumulatePoint(1L, 1000)),
                CompletableFuture.runAsync(() -> pointService.accumulatePoint(1L, 1000)),
                CompletableFuture.runAsync(() -> pointService.accumulatePoint(1L, 1000)),
                CompletableFuture.runAsync(() -> pointService.accumulatePoint(1L, 1000)),
                CompletableFuture.runAsync(() -> pointService.accumulatePoint(1L, 1000)),
                CompletableFuture.runAsync(() -> pointService.accumulatePoint(1L, 1000)),
                CompletableFuture.runAsync(() -> pointService.accumulatePoint(1L, 1000)),
                CompletableFuture.runAsync(() -> pointService.accumulatePoint(1L, 1000)),
                CompletableFuture.runAsync(() -> pointService.accumulatePoint(1L, 1000)),
                CompletableFuture.runAsync(() -> pointService.accumulatePoint(1L, 1000))
        ).join();

        Point point = pointService.getBy(1L);

        assertAll(
                () -> assertThat(point.getAmount()).isEqualTo(10000)
        );
    }
}
