package com.example.springdatajdbc.respository;

import com.example.springdatajdbc.domain.Pet;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, Integer> {

    @Query("select * from pet where name = :name")
    List<Pet> findByName(@Param("name") String name);
}
