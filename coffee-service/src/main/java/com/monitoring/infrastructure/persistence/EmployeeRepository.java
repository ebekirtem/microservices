package com.monitoring.infrastructure.persistence;

import com.monitoring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    Optional<List<Employee>>  findByFirstName (String name);
}
