package com.example.springdatajdbc.domain;

import org.springframework.data.annotation.Id;

public class Customer {

    @Id
    private Long id;
    private String name;
    private Address address;

    Customer(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public static Customer createCustomer(String name, Address address){
        return new Customer(null, name, address);
    }
}
