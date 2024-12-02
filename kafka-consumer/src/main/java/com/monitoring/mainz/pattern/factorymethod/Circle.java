package com.monitoring.mainz.pattern.factorymethod;

public class Circle implements Shape{
    private int radius;

    @Override
    public void draw() {
        System.out.println("Drawing circle");
    }
}
