package com.example.multithreading.video.chapter1;

import java.util.concurrent.TimeUnit;

public class AppleTree {
    private final String treeLabel;
    private final int numberOfApples;

    public AppleTree(String treeLabel) {
        this.treeLabel = treeLabel;
        this.numberOfApples = 3;
    }

    public static AppleTree[] newTreeGarden(int size) {
        AppleTree[] appleTrees = new AppleTree[size];
        for (int i = 0; i < appleTrees.length; i++) {
            appleTrees[i] = new AppleTree("Tree#" + i);
        }
        return appleTrees;
    }

    public int pickApples(String workerName) {
        try {
            System.out.printf("%s started picking apples from %s \n", workerName, treeLabel);
            TimeUnit.SECONDS.sleep(1);
            System.out.printf("%s picked %d Apples from %s \n", workerName, numberOfApples, treeLabel);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return numberOfApples;
    }

}
