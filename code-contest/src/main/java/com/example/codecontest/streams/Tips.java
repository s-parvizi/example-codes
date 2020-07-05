package com.example.codecontest.streams;

import java.util.Arrays;

public class Tips {
    public static void main(String[] args) {

        int[] test1 = new int[]{1, 2, 3, 4, 5};
        Integer[] test2 = new Integer[]{1, 2, 3, 4, 5};

        // This one doesn't print array members
        // Stream<int[]>
        System.out.println("Test1");
        Arrays.asList(test1).stream().forEach(System.out::println);

        // This one doesn't print array members
        System.out.println("Test2");
        Arrays.asList(test2).stream().forEach(System.out::println);

        // This one prints array members
        // Stream<int[]> -> flatMap -> IntStream
        System.out.println("Test3");
        Arrays.asList(test1).stream().flatMapToInt(x -> Arrays.stream(x)).forEach(System.out::println);

        // This one prints array members
        System.out.println("Test4");
        Arrays.stream(test1).forEach(System.out::println);
    }
}
