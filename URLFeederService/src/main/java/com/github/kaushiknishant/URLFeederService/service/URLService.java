package com.github.kaushiknishant.URLFeederService.service;

import com.github.kaushiknishant.URLFeederService.entity.URL;
import com.github.kaushiknishant.URLFeederService.repository.URLRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class URLService {

    private final URLRepository urlRepository;
    private final KafkaService kafkaService;
    private static  final  String topic = "html-topic";

    @Autowired
    public URLService(URLRepository urlRepository, KafkaService kafkaService){
        this.urlRepository = urlRepository;
        this.kafkaService = kafkaService;
    }


    public void save(URL url){
        log.info("Inside the save() method");
        log.debug("saving the url ----> " + url);
        urlRepository.save(url);
        log.info("Using Kafka send Method");
        kafkaService.send(topic, url.getUrl());
        log.info("Url is saved ");

    }
}
