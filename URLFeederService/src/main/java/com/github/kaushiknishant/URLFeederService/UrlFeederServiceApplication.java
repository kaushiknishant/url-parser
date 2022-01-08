package com.github.kaushiknishant.URLFeederService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.github.kaushiknishant.URLFeederService.repository")
public class UrlFeederServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlFeederServiceApplication.class, args);
	}

}
