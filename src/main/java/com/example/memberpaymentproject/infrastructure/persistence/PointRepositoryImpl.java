package com.example.memberpaymentproject.infrastructure.persistence;

import com.example.memberpaymentproject.domain.model.Member;
import com.example.memberpaymentproject.domain.model.Point;
import com.example.memberpaymentproject.domain.repository.PointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
class PointRepositoryImpl implements PointRepository {

    private final PointJpaRepository repository;


    @Override
    public Point getByMember(Member member) {
        return repository.findByMember(member).orElseThrow(
                () -> new IllegalArgumentException("")
        );
    }

    @Override
    public Point getByMemberWithPessimisticLock(Member member) {
        return repository.findByMemberWithPessimisticLock(member).orElseThrow(
                () -> new IllegalArgumentException("")
        );
    }

    @Override
    public Point save(Point point) {
        return repository.save(point);
    }

    @Override
    public Point getBy(Long pointId) {
        return repository.findById(pointId).orElseThrow(
                () -> new IllegalArgumentException("")
        );
    }
}
