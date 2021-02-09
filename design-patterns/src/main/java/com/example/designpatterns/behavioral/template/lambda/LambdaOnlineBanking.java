package com.example.designpatterns.behavioral.template.lambda;

import java.util.function.Consumer;

class LambdaOnlineBanking {
    // define processCustomer in a way for implementing template method pattern with lambda and method reference
    void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }
}