package com.monitoring.mainz.pattern.factorymethod;

public class MainClass {

    public static void main(String[] args) {

//        Shape shape = getShape("CIRCLE");
//
//        shape.draw();


        ShapeFactory circleFactory=new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw();

        ShapeFactory squareFactory=new SquareFactory();
        Shape square = squareFactory.createShape();
        square.draw();

    }

    public static Shape getShape(String shapeType){
        return switch (shapeType) {
            case "CIRCLE" -> new Circle();
            case "SQUARE" -> new Square();
            default -> throw new IllegalArgumentException("Illegal shape type" + shapeType);
        };
    }

}
