package com.example.codecontest.mcquestions;

import java.util.Arrays;
import java.util.Comparator;

public class Example2Compares {

    public static void main(String args[]) {
        String[] places = {"Bangalore", "Pune", "San Francisco", "New York City"};
        Arrays.sort(places, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(Arrays.binarySearch(places, "New York City"));
    }
}
