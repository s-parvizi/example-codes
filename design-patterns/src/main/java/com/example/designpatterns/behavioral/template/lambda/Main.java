package com.example.designpatterns.behavioral.template.lambda;

public class Main {
    public static void main(String[] args) {
        new LambdaOnlineBanking().processCustomer(1337, (Customer c) ->
                System.out.println("Hello " + c.getName()));
    }
}
