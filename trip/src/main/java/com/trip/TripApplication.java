package com.trip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// @EnableJpaRepositories("com.trip.repositories")
// @EntityScan("com.trip.models")
@SpringBootApplication
@ComponentScan(basePackages = "com.trip")
public class TripApplication {
	public static void main(String[] args) {
		SpringApplication.run(TripApplication.class, args);
	}
}