package com.monitoring.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name="person")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Person {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 255,unique = true,nullable = false)
    private String name;

    @Column(nullable = true)
    private Integer age;
}
