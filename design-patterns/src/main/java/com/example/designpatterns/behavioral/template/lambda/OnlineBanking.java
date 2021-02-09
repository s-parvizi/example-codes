package com.example.designpatterns.behavioral.template.lambda;

abstract class OnlineBanking {
    void processCustomer(int id){
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }
    abstract void makeCustomerHappy(Customer c);
}