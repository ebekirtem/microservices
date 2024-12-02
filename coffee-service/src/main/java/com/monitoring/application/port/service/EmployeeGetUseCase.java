package com.monitoring.application.port.service;

import com.monitoring.entity.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeGetUseCase {
    List<Employee> getAll();
    Employee getById(UUID id) throws InterruptedException;
    Employee getByIds(UUID id) throws InterruptedException;
    void saveAll();
    Employee save(Employee employee);
    Employee update(UUID id, Employee employee) throws InterruptedException;
    void batchInsert();
}
