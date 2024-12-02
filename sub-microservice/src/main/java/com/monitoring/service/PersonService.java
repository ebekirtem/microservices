package com.monitoring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.monitoring.domain.Person;
import com.monitoring.event.PersonCreatedEvent;
import com.monitoring.repository.PersonRepository;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final Logger logger= LoggerFactory.getLogger(PersonService.class);

    private final PersonRepository personRepository;
    private final WebClient webClient;
    private final ApplicationEventPublisher eventPublisher;
    //@Transactional("kafkaTransactionManager")
    @Transactional
    public Person savePerson(final Person person) {
        logger.info("Person Created: name:{} age:{}",person.getName(),person.getAge());
        Integer Id = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/Id")  // Base URL'ye endpoint ekle
                       // .queryParam("param", queryParam)  // Query parametresi ekle
                        .build())
                .retrieve()  // Yanıtı al
                .bodyToMono(Integer.class)
                .block();

        person.setAge(Id);
        Person savedPerson;

            // Bu satır exception fırlatıyor
            savedPerson = personRepository.save(person);
            logger.info("Saved person {}", savedPerson);

        eventPublisher.publishEvent(new PersonCreatedEvent(savedPerson));

        return savedPerson;
    }


    public List<Person> getAll(){
        return personRepository.findAll();
    }
}
