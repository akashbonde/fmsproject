package com.fmsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
public class FmsprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsprojectApplication.class, args);
		System.out.println("The application is now running!!");
		
	}

}
