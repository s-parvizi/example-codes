package com.example.designpatterns.behavioral.strategy;

public class Main {

    public static void main(String[] args) {
        var imageStore = new ImageStorage();
        // we can apply our desired configuration here
        imageStore.store("a", new JpegCompressor(), new BlackAndWhiteFilter());
        imageStore.store("a", new PngCompressor(), new BlackAndWhiteFilter());
    }
}