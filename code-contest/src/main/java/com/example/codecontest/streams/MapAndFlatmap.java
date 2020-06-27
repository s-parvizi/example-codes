package com.example.codecontest.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndFlatmap {

    public static void main(String[] args) {
        // print all unique letters
        List<String> words = List.of("JavaDevJournal", "Java");
        // Result should be: [J, a, v, D, e, o, u, r, n, l]

        // Stream<R>, input of map: Stream<String[]>, output: List<String[]>, what we want: List<String>
        List<String[]> list0 = words.stream()
                .map(a -> a.split(""))
                .distinct()
                .collect(Collectors.toList());

        // Solution 1
        List<String> list1 = words.stream()
                .map(a -> a.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        // Solution 2
        List<String> list2 = words.stream()
                .flatMap(a -> Arrays.stream(a.split("")))
                .distinct()
                .collect(Collectors.toList());
    }
}
