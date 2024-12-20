package com.monitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaConsumerApp {
    public static void main(String[] args) {
                 SpringApplication.run(KafkaConsumerApp.class,args);
    }
}