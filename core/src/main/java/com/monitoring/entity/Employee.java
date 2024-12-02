package com.monitoring.entity;

import com.monitoring.enums.Position;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="employees")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    @Id
    @GeneratedValue
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq_gen")
//    @SequenceGenerator(
//            name = "employee_seq_gen",
//            sequenceName = "employee_seq",
//            allocationSize = 20  // allocationSize = 1, her ID için sequence'e çağrı yapar
//    )
    private UUID id;

    @Column(name="first_name",nullable = false)
    private String firstName;

    @Column(name="last_name",nullable = false)
    private String lastName;

    @Column(name="position", nullable = false)
    @Enumerated(EnumType.STRING)
    private Position position;

    private BigDecimal salary;



}
