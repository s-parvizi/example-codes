package com.example.springdatajdbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("pet")
public class Pet {

    @Id
    private Long id;

    private String name;

    @Column("birth_date")
    private LocalDate birthDate;

    public Pet(Long id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public static Pet create(String name, LocalDate birthDate) {
        return new Pet(null, name, birthDate);
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
