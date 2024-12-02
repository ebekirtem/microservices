package com.monitoring.infrastructure.persistence;

import com.monitoring.application.port.output.CoffeRepository;
import com.monitoring.entity.Coffee;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CoffeeRepositoryAdapter implements CoffeRepository {

    private final  CoffeeJPARepository coffeeJPARepository;

    @Override
    public Optional<Coffee> findById(UUID id) {
        return coffeeJPARepository.findById(id);
    }

    @Override
    public Coffee save(Coffee coffee) {
        return coffeeJPARepository.save(coffee);
    }

    @Override
    public void delete(Coffee coffee) {
        coffeeJPARepository.delete(coffee);
    }

    @Override
    public Slice<Coffee> findAll(Pageable pageable) {
        return coffeeJPARepository.findAllBy(pageable);
    }
}
