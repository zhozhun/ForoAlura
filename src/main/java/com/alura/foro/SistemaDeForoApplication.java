package com.alura.foro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.alura.foro.model")
public class SistemaDeForoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeForoApplication.class, args);
	}

}
