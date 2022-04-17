package com.fmsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages = {"com.fmsproject"})
@EnableSwagger2
@SpringBootApplication
@Configuration("com.fmsproject.controller")
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
public class FmsprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsprojectApplication.class, args);
		System.out.println("The application is now running!!");
		
	}
	
	//The URL for the swagger is : http:localhost:8086/swagger-ui.html 
	@Bean
	public Docket fmsprojectapi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.fmsproject")).build();
	}

}
