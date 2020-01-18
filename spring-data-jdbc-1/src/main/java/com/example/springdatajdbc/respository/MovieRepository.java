package com.example.springdatajdbc.respository;

import com.example.springdatajdbc.domain.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
