package com.example.memberpaymentproject.infrastructure.persistence;

import com.example.memberpaymentproject.domain.model.PointDetails;
import com.example.memberpaymentproject.domain.repository.PointDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
class PointDetailsRepositoryImpl implements PointDetailsRepository {

    private final PointDetailsJpaRepository repository;

    @Override
    public PointDetails save(PointDetails pointDetails) {
        return repository.save(pointDetails);
    }
}
