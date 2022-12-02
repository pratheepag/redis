package com.example.redis11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
public class Redis11Application {

	public static void main(String[] args) {
		SpringApplication.run(Redis11Application.class, args);
	}

}
