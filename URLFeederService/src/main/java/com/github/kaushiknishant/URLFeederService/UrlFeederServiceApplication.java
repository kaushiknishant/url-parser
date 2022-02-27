package com.github.kaushiknishant.URLFeederService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.github.kaushiknishant.URLFeederService.repository")
@Slf4j
public class UrlFeederServiceApplication {

	public static void main(String[] args) {
		log.info("Inside the main method");
		SpringApplication.run(UrlFeederServiceApplication.class, args);
	}

}
