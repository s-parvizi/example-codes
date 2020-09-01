package com.example.modernjava.chap03;

import java.util.function.DoubleFunction;
import java.util.function.DoubleUnaryOperator;

public class Integral {

    public static void main(String[] args) {
        double r1 = integrate1(value -> value + 10, 3, 7);
        System.out.println(r1);

        double r2 = integrate2(value -> value + 10, 3, 7);
        System.out.println(r2);
    }

    public static double integrate1(DoubleFunction<Double> f, double a, double b) {
        return (f.apply(a) + f.apply(b)) * (b - a) / 2.0;
    }

    public static double integrate2(DoubleUnaryOperator f, double a, double b) {
        return (f.applyAsDouble(a) + f.applyAsDouble(b)) * (b - a) / 2.0;
    }
}
