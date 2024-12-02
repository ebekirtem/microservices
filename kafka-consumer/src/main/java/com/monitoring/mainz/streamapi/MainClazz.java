package com.monitoring.mainz.streamapi;

import com.monitoring.mainz.alg.Fibonacci;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainClazz {
    public static void main(String[] args) {
        Integer[] array={4,5,6,4,4,23,43,22,42,1,5,0,-3};
        Optional<Integer> sum = Arrays.stream(array).filter(n -> n % 2 == 0).map(n -> n * n).reduce(Integer::sum);
        if (sum.isPresent()){
            System.out.println(sum.get());
        }

        Fibonacci fibonacci=new Fibonacci();


        Consumer<Integer> consumer=(a)-> System.out.println();
        consumer.accept(6);

        Function<Integer,Boolean> function=(n)-> n % 2 == 0;
        Boolean apply = function.apply(5);


        List<Student> students=Arrays.asList(new Student("Ebubekir",List.of(5,4,2)),
                new Student("Tarık",List.of(5,7,8)),
                new Student("Zümra",List.of(9,7,6)),
                new Student("Reyyan",List.of(8,4,5))
        );

        List<String> nameList = students.stream().filter(student -> student.getGrades().stream().mapToInt(Integer::intValue).average().orElse(0) > 5)
                .map(Student::getName).toList();


        List<Product> products = Arrays.asList(
                new Product("Laptop", 1500.0),
                new Product("Phone", 800.0),
                new Product("Tablet", 400.0),
                new Product("Monitor", 300.0)
        );

        double v = products.stream().mapToDouble(Product::getPrice).average().orElse(0);
        System.out.println(v);

    }

    static class Student{
        private String name;
        private List<Integer> grades;

        public Student(String name, List<Integer> grades) {
            this.name = name;
            this.grades = grades;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Integer> getGrades() {
            return grades;
        }

        public void setGrades(List<Integer> grades) {
            this.grades = grades;
        }
    }

    static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }
    }


}
