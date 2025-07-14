package com.shahinkhalajestani.reservations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:resultstatus.properties")
public class ReservationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationsApplication.class, args);
	}

}
