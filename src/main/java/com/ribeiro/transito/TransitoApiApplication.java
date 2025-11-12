package com.ribeiro.transito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.ribeiro")
@EntityScan("com.ribeiro.domain.model")
@EnableJpaRepositories(basePackages = "com.ribeiro.domain.repository")
public class TransitoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransitoApiApplication.class, args);
	}

}
