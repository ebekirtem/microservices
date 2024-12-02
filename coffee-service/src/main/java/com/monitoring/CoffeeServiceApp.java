package com.monitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CoffeeServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(CoffeeServiceApp.class,args);
    }
}