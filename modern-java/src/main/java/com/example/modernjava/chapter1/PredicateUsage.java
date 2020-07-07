package com.example.modernjava.chapter1;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.awt.Color.GREEN;

public class PredicateUsage {

    public static void main(String[] args) {
        List<Apple> inventory = List.of(new Apple(GREEN, 100), new Apple(Color.RED, 200) );

        // 0. without predicate

        // 1. with predicate
        System.out.println(filterApples(inventory, Apple::isGreenApple));

        // 2. with predicate and lambdas
        //System.out.println(filterApples(inventory, Apple::isHeavyApple));
        // better approach here is to use anonymous functions or lambdas for such a method that we use just one time
        System.out.println(filterApples(inventory, (Apple a) ->  a.getWeight() > 150));

        // 3. with predicate and lambdas and using filter
        //System.out.println(filter(inventory, (Apple a) ->  a.getWeight() > 150 || GREEN.equals(a.getColor()) ));
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}

class Apple {
    private Color color;
    private int weight;

    public Apple(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public static boolean isGreenApple(Apple apple) {
        return GREEN.equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
}

