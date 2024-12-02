package com.monitoring.application.port.service;

import com.monitoring.entity.Employee;
import com.monitoring.enums.Position;
import com.monitoring.infrastructure.persistence.EmployeeRepository;
import com.zaxxer.hikari.util.IsolationLevel;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService implements EmployeeGetUseCase {

    private final EmployeeRepository employeeRepository;
    private final EntityManager entityManager;

    @Cacheable(value = "employees")
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Employee getById(UUID id) throws InterruptedException {
        Employee employee = employeeRepository.findById(id).orElseThrow(RuntimeException::new);

        System.out.println(employee.toString());


        Thread.sleep(10000);


        Employee employee2 = getByIds(id);

        System.out.println(employee2.toString());

        return employee2;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public  Employee getByIds(UUID id)  {
       return employeeRepository.findById(id).orElseThrow(RuntimeException::new);
    }


    @Transactional
    public void batchInsert() {
        int batchSize = 20;

        List<Employee> list=new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            Employee emp1 = Employee.builder()
                    .firstName("Ebut")
                    .lastName("Temiz")
                    .salary(BigDecimal.valueOf(3434.33))
                    .position(Position.Administrator)
                    .build();
            list.add(emp1);
        }

        for (int i = 0; i < list.size(); i++) {
            entityManager.persist(list.get(i));

            if (i > 0 && i % batchSize == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }

        entityManager.flush();
        entityManager.clear();
    }

    public void saveAll() {
        List<Employee> list=new ArrayList<>();
        for (int i = 0; i <10000 ; i++) {
        Employee emp1 = Employee.builder()
                .firstName("Ebut")
                .lastName("Temiz")
                .salary(BigDecimal.valueOf(3434.33))
                .position(Position.Administrator)
                .build();
            list.add(emp1);
        }


        employeeRepository.saveAll(list);
    }

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Employee save(Employee employee) {
        Employee saved = employeeRepository.save(employee);
        System.out.println(saved);
        return saved;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Employee update(UUID id, Employee employee) throws InterruptedException {
        Optional<Employee> emp = employeeRepository.findById(id);

        if(emp.isPresent()){
            Employee foundEmp = emp.get();
            foundEmp.setFirstName(employee.getFirstName());
            foundEmp.setLastName(employee.getLastName());
            foundEmp.setPosition(employee.getPosition());
            foundEmp.setSalary(employee.getSalary());
            Employee saved = employeeRepository.save(foundEmp);

            Thread.sleep(10000);

            return saved;

        }
        else {
            throw  new RuntimeException("Update exception");
        }
    }
}

