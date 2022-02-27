package com.github.kaushiknishant.URLFeederService.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaService(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, String message) {
        log.info("Inside Kafka send method ");
        log.debug("saving into topic: "+ topic +"message: " + message);
        kafkaTemplate.send(topic, message);
    }
}
