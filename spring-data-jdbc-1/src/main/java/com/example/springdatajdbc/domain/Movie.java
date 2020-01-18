package com.example.springdatajdbc.domain;

import org.springframework.data.annotation.Id;

import java.util.Set;

public class Movie {

    @Id
    private Long id;

    private String title;

    private String description;

    private Set<Rental> rental;

    public Movie(Long id, String title, String description, Set<Rental> rental) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rental = rental;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rental=" + rental +
                '}';
    }
}
