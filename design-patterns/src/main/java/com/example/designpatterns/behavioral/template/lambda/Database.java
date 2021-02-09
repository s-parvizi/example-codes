package com.example.designpatterns.behavioral.template.lambda;

public class Database {
    public static Customer getCustomerWithId(int id) {
        return new Customer(id, "Tom");
    }
}
