package com.monitoring.mainz.pattern.builder;

public class MainClazz {
    public static void main(String[] args) {
        Car car=Car.builder()
                .setName("formentor")
                .setModel("Fromentor 1.6")
                .setBrand("Cupra")
                .setYear(2022)
                .build();



    }
}
