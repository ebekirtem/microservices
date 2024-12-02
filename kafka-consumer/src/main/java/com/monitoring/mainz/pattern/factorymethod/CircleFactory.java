package com.monitoring.mainz.pattern.factorymethod;

public class CircleFactory extends ShapeFactory{
    @Override
    public Shape createShape() {
        return new Circle();
    }
}
