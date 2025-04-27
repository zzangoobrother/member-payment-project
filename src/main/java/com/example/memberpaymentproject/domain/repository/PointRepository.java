package com.example.memberpaymentproject.domain.repository;

import com.example.memberpaymentproject.domain.model.Member;
import com.example.memberpaymentproject.domain.model.Point;

public interface PointRepository {

    Point getByMember(Member member);

    Point save(Point point);
}
