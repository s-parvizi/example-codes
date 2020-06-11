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

		// Variable Type Inference

		// 1. Initializers
	    var programmingLanguage = "Java";
        System.out.println(programmingLanguage);

	    var myArray = new String[]{"test1", "test2", "test3"};
	    // 2. Indexes in enhanced for-loops
        for (var s: myArray){
            System.out.println(s);
        }

        // 3. Local variables initialized in a traditional for-loop
        for (var i = 0; i < 10; i++) {
            System.out.println(i);
        }

        return arge->{
			// Write code to test after Spring Application Context load
		};
	}

}
