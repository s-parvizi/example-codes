package com.example.java10;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Java10Application {

	public static void main(String[] args) {
		SpringApplication.run(Java10Application.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(){
		var programmingLanguage = "Java";
		return arge->{
			// Write code to test after Spring Application Context load
			System.out.println(programmingLanguage);
		};
	}

}
