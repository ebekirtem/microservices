package com.monitoring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Logger logger= LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/{name}")
    public String hello(@PathVariable("name") String name){
        return "Hello "+ name;
    }

    @GetMapping("/find/{number}")
    public Boolean find(@PathVariable("number") Integer number){
        logger.info("Called controller method wit param {}",number);
        for (int i=0;i<10000000;i++){
            if(i==number){
                return true;
            }
        }
        return false;
    }

}
