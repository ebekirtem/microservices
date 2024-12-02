package com.monitoring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerListener {

    private final Logger logger= LoggerFactory.getLogger(KafkaConsumerListener.class);
    @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(String message){
            logger.info("Message Consumed: {}",message);
    }

}
