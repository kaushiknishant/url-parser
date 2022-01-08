package com.github.kaushiknishant.URLFeederService.service;

import com.github.kaushiknishant.URLFeederService.entity.URL;
import com.github.kaushiknishant.URLFeederService.repository.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLService {

    @Autowired
    private URLRepository urlRepository;

    public void save(URL url){
        urlRepository.save(url);
    }
}
