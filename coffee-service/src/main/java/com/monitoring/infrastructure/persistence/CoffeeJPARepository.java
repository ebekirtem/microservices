package com.monitoring.infrastructure.persistence;

import com.monitoring.entity.Coffee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoffeeJPARepository extends JpaRepository<Coffee, UUID> {
    Slice<Coffee> findAllBy(Pageable pageable);
}
