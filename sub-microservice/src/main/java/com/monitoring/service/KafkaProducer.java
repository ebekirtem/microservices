package com.monitoring.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private static final Logger logger= LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String,String> kafkaTemplate;
    private  final NewTopic topic;
    public void sendMessage(String message){
        logger.info("Send message {}",message);
        kafkaTemplate.send(topic.name(),message);
    }

}
