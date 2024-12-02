package com.monitoring.mainz.pattern.factorymethod;

public class SquareFactory extends ShapeFactory{
    @Override
    public Shape createShape() {
        return new Square();
    }
}
