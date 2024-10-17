package com.beto.skyler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SkylerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkylerApplication.class, args);
	}

}
