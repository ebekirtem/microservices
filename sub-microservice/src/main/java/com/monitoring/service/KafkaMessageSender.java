package com.monitoring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.monitoring.event.PersonCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class KafkaMessageSender {

    private final KafkaProducer kafkaProducer;
    private final ObjectMapper objectMapper;
    private final Logger logger= LoggerFactory.getLogger(KafkaMessageSender.class);

    @TransactionalEventListener
    public void handlePersonCreatedEvent(PersonCreatedEvent event) {
        try {
            String personJson = objectMapper.writeValueAsString(event.person());
            logger.info("Person as json {}", personJson);
            kafkaProducer.sendMessage(personJson);  // Kafka mesajı burada gönderilir, transaction başarılı olduktan sonra
        } catch (JsonProcessingException jsonProcessingException) {
            throw new RuntimeException("Message convert exception occurred");
        }
    }
}