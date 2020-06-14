package com.example.multithreading.video.section1;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class PickFruitsWithRecursiveAction {

    public static void main(String[] args) throws InterruptedException {
        AppleTree[] appleTrees = AppleTree.newTreeGarden(12);
        ForkJoinPool pool = ForkJoinPool.commonPool();

        long startTime = System.currentTimeMillis();
        PickFruitAction task = new PickFruitAction(appleTrees, 0, appleTrees.length - 1);
        //pool.invoke(task);
        pool.execute(task);
        //task.join();
        pool.awaitTermination(10, TimeUnit.SECONDS);

        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("Done in: " + (endTime - startTime));
    }

    public static class PickFruitAction extends RecursiveAction {
        private final AppleTree[] appleTrees;
        private final int startInclusive;
        private final int endInclusive;

        private final int taskThreadholds = 4;


        public PickFruitAction(AppleTree[] appleTrees, int startInclusive, int endInclusive) {
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
        protected void compute() {
            if (endInclusive - startInclusive < taskThreadholds) {
                doCompute();
                return;
            }

            int midpont = startInclusive + (endInclusive - startInclusive) / 2;

            PickFruitAction leftSum = new PickFruitAction(appleTrees, startInclusive, midpont);
            PickFruitAction rightSum = new PickFruitAction(appleTrees, midpont + 1, endInclusive);

            rightSum.fork(); // computed asynchronously

            leftSum.compute(); // computed synchronously: immediately and in the current thread
            rightSum.join();
        }
    }
}
