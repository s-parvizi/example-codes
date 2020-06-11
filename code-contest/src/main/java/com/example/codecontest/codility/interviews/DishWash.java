package com.example.codecontest.codility.interviews;

public class DishWash {

    public static void main(String[] args) {
        String dish = "10 i1 i2 i3\n30 i4 i1 i5 i6\n5 i5 i2 i3 i6 i11\n45 i8 i1 i9 i10";
        String s = solution(dish);
        System.out.println(s);
    }

    public static String solution(String D) {
        String dishes[] = D.split("\\n");
        int[] values = new int[D.length()];

        for (int i = 0; i < dishes.length; i++) {
            String item = dishes[i];
            String[] nums = item.split(" i");

            for (int j = 1; j < nums.length; j++) {
                values[Integer.valueOf(nums[j])] = values[Integer.valueOf(nums[j])] + (Integer.valueOf(nums[0]));
            }
        }

        int max = values[1];
        int maxIndex = 1;
        for (int l = 1; l < values.length; l++) {
            if (values[l] > max) {
                max = values[l];
                maxIndex = l;
            }
        }

        return "i" + maxIndex;
    }
}
