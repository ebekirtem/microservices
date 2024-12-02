package com.monitoring.infrastructure.web;

import com.monitoring.application.port.service.EmployeeGetUseCase;
import com.monitoring.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/employee")
public class EmployeeController {
    private final EmployeeGetUseCase employeeGetUseCase;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getEmployees(){
        return ResponseEntity.ok(employeeGetUseCase.getAll());
    }

    @PostMapping("/saveAll")
    public ResponseEntity<Void> saveEmployees(){
        employeeGetUseCase.saveAll();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        Employee saved = employeeGetUseCase.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable UUID id, @RequestBody Employee employee) throws InterruptedException {
        Employee saved = employeeGetUseCase.update(id,employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<Employee> getEmployeeById(@RequestParam UUID id) throws InterruptedException {
        Employee emp = employeeGetUseCase.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(emp);
    }
}
