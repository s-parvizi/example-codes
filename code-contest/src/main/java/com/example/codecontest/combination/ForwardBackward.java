package com.example.codecontest.combination;

import java.util.Arrays;

public class ForwardBackward {
    public static void main(String[] args) {
        int[] testArr = new int[]{1, 2, 3};
        combination(testArr, 2);
    }

    private static void combination(int[] elements, int k) {
        //FIXME
        int[] pointers = new int[k];
        int i = 0;
        int r = 0;
        while (r < elements.length) {
            if (r == k) {
                while (r < elements.length) {
                    Arrays.stream(pointers).forEach(m -> System.out.print(elements[m] + " "));
                    System.out.println();
                    r++;
                    pointers[r] = r;
                }
                i++;
                r=i;
            }
            pointers[r] = r;
            r++;
        }
    }
}
