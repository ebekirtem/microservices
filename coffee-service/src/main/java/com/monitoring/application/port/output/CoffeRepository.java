package com.monitoring.application.port.output;

import com.monitoring.entity.Coffee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.Optional;
import java.util.UUID;

public interface CoffeRepository {
    Optional<Coffee> findById(UUID id);
    Coffee save(Coffee coffee);
    void delete (Coffee coffee);
    Slice<Coffee> findAll(Pageable pageable);
}
