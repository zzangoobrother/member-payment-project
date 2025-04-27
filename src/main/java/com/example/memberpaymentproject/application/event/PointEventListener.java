package com.example.memberpaymentproject.application.event;

import com.example.memberpaymentproject.application.event.dto.CreatePointDto;
import com.example.memberpaymentproject.application.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@RequiredArgsConstructor
@Component
public class PointEventListener {

    private final PointService pointService;

    @Async("eventAsyncExecutor")
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void addInquiryCount(CreatePointDto event) {
        pointService.createPoint(event.memberId(), event.amount());
    }
}
