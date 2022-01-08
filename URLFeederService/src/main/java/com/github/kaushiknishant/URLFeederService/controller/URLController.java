package com.github.kaushiknishant.URLFeederService.controller;

import com.github.kaushiknishant.URLFeederService.entity.URL;
import com.github.kaushiknishant.URLFeederService.service.URLService;
import com.github.kaushiknishant.URLFeederService.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.UUID;

@RestController
class URLController {

    @Autowired
    private URLService urlService;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping
    public ResponseEntity<Void> submitURL(@RequestBody URL url) {
        url.setId(Constants.URL_UUID_PREFIX + UUID.randomUUID().toString());
        url.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        urlService.save(url);
        System.out.println(url);
        return ResponseEntity.ok().build();
    }
}
