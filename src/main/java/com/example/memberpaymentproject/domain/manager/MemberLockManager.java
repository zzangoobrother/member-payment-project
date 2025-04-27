package com.example.memberpaymentproject.domain.manager;

import com.example.memberpaymentproject.interfaces.presentation.response.SearchMemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.ReentrantLock;

@RequiredArgsConstructor
@Component
public class MemberLockManager {
    private ReentrantLock lock = new ReentrantLock();

    private final MemberManager memberManager;

    public SearchMemberResponse updateInquiry(Long memberId) {
        lock.lock();
        try {
            return memberManager.updateInquiry(memberId);
        } finally {
            lock.unlock();
        }
    }
}
