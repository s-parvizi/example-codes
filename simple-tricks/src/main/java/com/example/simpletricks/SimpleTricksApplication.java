package com.example.simpletricks;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimpleTricksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleTricksApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(){
		return arge->{
			// Write code to test after Spring Application Context load
		};
	}

}
