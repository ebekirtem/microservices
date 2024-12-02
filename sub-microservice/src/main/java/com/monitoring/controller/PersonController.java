package com.monitoring.controller;

import com.monitoring.domain.Person;
import com.monitoring.service.AsyncService;
import com.monitoring.service.PersonService;
import io.micrometer.tracing.Tracer;
import liquibase.logging.LogFactory;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final AsyncService asyncService;
    private final Tracer tracer;

    private static final Logger logger= LoggerFactory.getLogger(PersonController.class);

    @PostMapping("/{name}")
    public ResponseEntity<Person> create(@PathVariable String name){
        logger.info("My Trace Id {} my span Id {}",tracer.currentSpan().context().traceId(),tracer.currentSpan().context().spanId());
        Person person=Person.builder().name(name).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.savePerson(person));
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAll(){
        return ResponseEntity.ok(personService.getAll());
    }

    @PostMapping("/save/all/{count}")
    public ResponseEntity<String> saveAll(@PathVariable Integer count){
        asyncService.saveAll(count);
       return ResponseEntity.ok().body("OK");
    }
}
