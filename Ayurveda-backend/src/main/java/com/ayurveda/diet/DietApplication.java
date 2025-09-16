// FileName: src/main/java/com/ayurveda/diet/DietApplication.java
package com.ayurveda.diet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate; // <-- Add this import

@SpringBootApplication
public class DietApplication {

	public static void main(String[] args) {
		SpringApplication.run(DietApplication.class, args);
	}

	// --- THIS IS THE FIX ---
	// The @Bean method must be INSIDE the class's curly braces {}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	// --- END FIX ---
}