package com.example.studentendpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication()

public class StudentendpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentendpointApplication.class, args);
	}

}
