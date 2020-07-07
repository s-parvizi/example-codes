package com.example.modernjava.tips;

public class Java10 {

    public static void main(String[] args) {

        // Variable Type Inference

        // 1. Initializers
        var programmingLanguage = "Java";
        System.out.println(programmingLanguage);

        var myArray = new String[]{"test1", "test2", "test3"};
        // 2. Indexes in enhanced for-loops
        for (var s : myArray) {
            System.out.println(s);
        }

        // 3. Local variables initialized in a traditional for-loop
        for (var i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
