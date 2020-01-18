package com.example.springdatajdbc.domain;

import org.springframework.data.annotation.Id;

public class Customer {

    @Id
    private Long id;
    private String name;

    Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Customer createCustomer(String name){
        return new Customer(null, name);
    }
}
