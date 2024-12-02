package com.monitoring.example;

import java.util.List;

public class MyRepo implements MyTpe<Person>{
    @Override
    public void add(Person person) {

    }

    @Override
    public List<Person> getAll() {
        return List.of();
    }
}
