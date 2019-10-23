package com.example.springdatajdbc;

import com.example.springdatajdbc.domain.*;
import com.example.springdatajdbc.respository.CustomerRepository;
import com.example.springdatajdbc.respository.MovieRepository;
import com.example.springdatajdbc.respository.PetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class SpringDataJdbcApplicationTests {

    @Autowired
    PetRepository petRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MovieRepository movieRepository;

    @Test
    void testBasic() {
        Pet pet1 = Pet.create("Zonbe", LocalDate.of(2017, 1, 1));
        Pet pet2 = Pet.create("Parikal", LocalDate.of(2014, 1, 1));
        // with constructor save does not work, because id has a value
        //Pet pet2 = new Pet(2L, "Parikal", LocalDate.of(2014, 1, 1));
        System.out.println(petRepository.save(pet1));
        System.out.println(petRepository.save(pet2));
        System.out.println(petRepository.findByName("Parikal"));
    }

    @Test
    void testOneToOne() {
        Address customerAddress = new Address("Test Address");
        Customer customer = Customer.createCustomer("patrick", customerAddress);

        System.out.println(customerRepository.save(customer));

        System.out.println(customerRepository.findAll());
    }

    @Test
    void testOneToMany() {
        Set<Rental> rentals = new HashSet<Rental>();
        rentals.add(new Rental(Duration.ofDays(1), 2));
        rentals.add(new Rental(Duration.ofDays(7), 10));

        Movie movie = new Movie(null, "Mask", "description...,",
                rentals);

        movieRepository.save(movie);

        System.out.println(movieRepository.findAll());
    }

    @Test
    void test() {
        testOneToOne();
        System.out.println(customerRepository.findByNameRowMapper("patrick"));
    }

}
