package com.example.codecontest.codility.lessons;

// Lessons-Iterations-BinaryGap
class BinaryGap {
    public static void main(String[] args) {
        System.out.println(solution(529));
    }

    private static int solution(int N) {
        String binaryString = Integer.toBinaryString(N);
        int lastFindPosition = 0;
        int gap = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.indexOf("1", i) - lastFindPosition > gap)
                gap = binaryString.indexOf("1", i) - lastFindPosition - 1;
            lastFindPosition = binaryString.indexOf("1", i);
            if (lastFindPosition == binaryString.length() - 1)
                return gap;
        }
        return gap;
    }
}
