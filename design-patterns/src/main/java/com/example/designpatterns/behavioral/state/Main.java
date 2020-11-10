package com.example.designpatterns.behavioral.state;

public class Main {

    public static void main(String[] args) {
        var canvas = new Canvas();
        // we can easily set our desired tool here BrushTool or EraserTool
        canvas.setCurrentTool(new BrushTool());
        canvas.mouseDown();
        canvas.mouseUp();
    }
}
