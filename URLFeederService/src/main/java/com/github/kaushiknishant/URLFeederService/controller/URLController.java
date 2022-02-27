package com.github.kaushiknishant.URLFeederService.controller;

import com.github.kaushiknishant.URLFeederService.entity.URL;
import com.github.kaushiknishant.URLFeederService.service.URLService;
import com.github.kaushiknishant.URLFeederService.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.UUID;

@RestController
@Slf4j
class URLController {

    private final URLService urlService;

    /*
    @Autowired
    private URLService urlService
    Field-based dependency injection is not recommended

    Disadvantages:
        ----> Disallows immutable field declaration
        ----> Eases single responsibility principle violation
        ----> Tightly coupled with dependency injection container
        ----> Hidden dependencies
     */

    @Autowired
    public URLController(URLService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/")
    public String home() {
        log.info("<---- Inside the home() ---> ");
        return "Welcome to the site. ";
    }

    @PostMapping
    public ResponseEntity<Void> submitURL(@RequestBody URL url) {
        log.info("<----Inside the submitURL() ---> ");
        url.setId(Constants.URL_UUID_PREFIX + UUID.randomUUID());
        url.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        log.info("URLService save method is used.");
        urlService.save(url);
        return ResponseEntity.ok().build();
    }
}
