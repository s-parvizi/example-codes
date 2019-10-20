package com.example.springdatajdbc;

import com.example.springdatajdbc.domain.Pet;
import com.example.springdatajdbc.respository.PetRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class SpringDataJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(PetRepository petRepository) {
        return arge -> {
            Pet pet1 = Pet.create("Zonbe", LocalDate.of(2017, 1, 1));

            Pet pet2 = Pet.create("Parikal", LocalDate.of(2014, 1, 1));

            // with constructor save does not work, because id has a value
            //Pet pet2 = new Pet(2L, "Parikal", LocalDate.of(2014, 1, 1));

            System.out.println(petRepository.save(pet1));
            System.out.println(petRepository.save(pet2));

            System.out.println(petRepository.findByName("Parikal"));
        };
    }

}
