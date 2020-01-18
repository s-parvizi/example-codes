package com.example.springdatajdbc.respository;

import com.example.springdatajdbc.domain.Customer;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    @Query(value = "select name, count(*) from customer where name = :name")
    List<Customer> findByName(@Param("name") String name);

}
