package com.monitoring.mainz.pattern.builder;

public class Car {
    private final String name;
    private final String model;
    private final String brand;
    private final Integer year;

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getYear() {
        return year;
    }


    private Car(Builder builder) {
        this.name = builder.name;
        this.model = builder.model;
        this.brand =builder. brand;
        this.year =builder. year;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String name;
        private String model;
        private String brand;
        private Integer year;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setYear(Integer year) {
            this.year = year;
            return this;
        }

        public Car build(){
            return new Car(this);
        }
    }

}
