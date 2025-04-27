package com.example.memberpaymentproject.infrastructure.persistence;

import com.example.memberpaymentproject.domain.model.PointDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointDetailsJpaRepository extends JpaRepository<PointDetails, Long> {
}
