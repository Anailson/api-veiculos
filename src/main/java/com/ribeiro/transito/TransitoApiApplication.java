package com.ribeiro.transito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.ribeiro")
@EntityScan("com.ribeiro.domain.model") // força o scan das entidades
public class TransitoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransitoApiApplication.class, args);
	}

}
