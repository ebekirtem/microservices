package com.monitoring.service;

import com.monitoring.domain.Person;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AsyncService {
    
    private final PersonService personService;
    private final Logger logger= LoggerFactory.getLogger(AsyncService.class);

    @Async
    public void saveAll(Integer count) {
        try {
            for (int i = 0; i < count; i++) {
                Person p = Person.builder()
                        .id(UUID.randomUUID())
                        .name(UUID.randomUUID().toString())
                        .build();
                personService.savePerson(p); // Veritabanına kaydetme ve Kafka'ya gönderme
                logger.info("{}. message produced", i + 1);
            }
        } catch (Exception e) {
            logger.error("Exception occurred while processing: {}", e.getMessage());
        }
    }
}
