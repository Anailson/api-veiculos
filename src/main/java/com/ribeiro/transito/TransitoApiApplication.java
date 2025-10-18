package com.ribeiro.transito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ribeiro")
public class TransitoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransitoApiApplication.class, args);
	}

}
