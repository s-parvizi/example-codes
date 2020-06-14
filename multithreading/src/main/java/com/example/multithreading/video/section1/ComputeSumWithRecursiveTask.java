package com.example.multithreading.video.section1;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class ComputeSumWithRecursiveTask {

    public static void main(String[] args) {
        int[] numbers = new int[] {1,2,3,4,5,6,7,8,9,10};
        ForkJoinPool pool = ForkJoinPool.commonPool();

        ComputeSumTask task = new ComputeSumTask(numbers, 0, numbers.length - 1);
        int sum = pool.invoke(task);

        System.out.println(sum);
    }

    public static class ComputeSumTask extends RecursiveTask<Integer> {
        private final int[] numbers;
        private final int startInclusive;
        private final int endInclusive;

        private final int taskThreadholds = 2;


        public ComputeSumTask(int[] numbers, int startInclusive, int endInclusive) {
            this.numbers = numbers;
            this.startInclusive = startInclusive;
            this.endInclusive = endInclusive;
        }

        protected Integer doCompute() {
            return IntStream.rangeClosed(startInclusive, endInclusive)
                    .map(i -> numbers[i])
                    .sum();
        }

        @Override
        protected Integer compute() {
            if (endInclusive - startInclusive < taskThreadholds) {
                return doCompute();
            }

            int midpont = startInclusive + (endInclusive - startInclusive) / 2;

            ComputeSumTask leftSum = new ComputeSumTask(numbers, startInclusive, midpont);
            ComputeSumTask rightSum = new ComputeSumTask(numbers, midpont + 1, endInclusive);

            rightSum.fork();
            return leftSum.compute() + rightSum.join();
        }
    }
}
