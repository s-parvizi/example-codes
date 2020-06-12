package com.example.multithreading.video.chapter1;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class PickFruitsWithRecursiveTask {

    public static void main(String[] args) {
        AppleTree[] appleTrees = AppleTree.newTreeGarden(12);
        ForkJoinPool pool = ForkJoinPool.commonPool();

        PickFruitTask task = new PickFruitTask(appleTrees, 0, appleTrees.length - 1);
        int result = pool.invoke(task);

        System.out.println();
        System.out.println("Total apples picked: " + result);
    }

    public static class PickFruitTask extends RecursiveTask<Integer> {
        private final AppleTree[] appleTrees;
        private final int startInclusive;
        private final int endInclusive;

        private final int taskThreadholds = 4;


        public PickFruitTask(AppleTree[] appleTrees, int startInclusive, int endInclusive) {
            this.appleTrees = appleTrees;
            this.startInclusive = startInclusive;
            this.endInclusive = endInclusive;
        }

        protected Integer doCompute() {
            return IntStream.rangeClosed(startInclusive, endInclusive)
                    .map(i -> appleTrees[i].pickApples(""))
                    .sum();
        }

        @Override
        protected Integer compute() {
            if (endInclusive - startInclusive < taskThreadholds) {
                return doCompute();
            }

            int midpont = startInclusive + (endInclusive - startInclusive) / 2;

            PickFruitTask leftSum = new PickFruitTask(appleTrees, startInclusive, midpont);
            PickFruitTask rightSum = new PickFruitTask(appleTrees, midpont + 1, endInclusive);

            rightSum.fork();
            return leftSum.compute() + rightSum.join();
        }
    }
}
