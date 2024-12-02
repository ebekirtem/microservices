package com.monitoring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="tbl_coffee")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String imageUrl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Objects.equals(id, coffee.id) && Objects.equals(name, coffee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
