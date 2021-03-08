package com.example.designpatterns.behavioral.strategy.lambda;

public class Main {

    public static void main(String[] args) {
        // without using lambda
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaaa");
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbbb");

        // using lambda
        Validator numericValidator2 =
                new Validator((String s) -> s.matches("[a-z]+"));
        boolean b3 = numericValidator.validate("aaaa");
        Validator lowerCaseValidator2 =
                new Validator((String s) -> s.matches("\\d+"));
        boolean b4 = lowerCaseValidator.validate("bbbb");
    }
}
