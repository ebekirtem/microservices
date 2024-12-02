package com.monitoring.config;

import com.monitoring.domain.Person;
import com.monitoring.event.PersonCreatedEvent;
import com.monitoring.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {
    private final static Logger logger= LoggerFactory.getLogger(Runner.class);
    @Override
    public void run(String... args) {
        logger.info("Started");
    }
}
