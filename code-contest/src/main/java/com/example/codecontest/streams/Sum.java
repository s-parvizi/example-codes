package com.example.codecontest.streams;

import java.util.Arrays;
import java.util.List;

public class Sum {

    public static void main(String[] args) {
        // Using Stream.reduce()

        // Method 1
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = integers.stream()
                .reduce(0, (a, b) -> a + b);

        // Method 2
        sum = integers.stream()
                .reduce(0, Integer::sum);

        // Method 3
        sum = integers.stream()
                .reduce(0, Integer::sum);

        sum = integers.stream()
                .reduce(0, ArithmeticUtils::add);

        System.out.println(sum);



    }

    public static class ArithmeticUtils {

        public static int add(int a, int b) {
            return a + b;
        }
    }
}
