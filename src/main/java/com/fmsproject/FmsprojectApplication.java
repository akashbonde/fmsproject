package com.fmsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SuppressWarnings("deprecation")
@EnableSwagger2
@SpringBootApplication
@Configuration("com.fmsproject.controller")
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
public class FmsprojectApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(FmsprojectApplication.class, args);
		System.out.println("The application is now running!!");
		
	}
	
	//The URL for the swagger is : http://localhost:8086/swagger-ui/
	@Bean
	public Docket fmsprojectapi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.fmsproject"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(generateApiInfo());
	}
	
	private ApiInfo generateApiInfo()
	{
		return new ApiInfo(
	            "Feedback Management System","Efficiently manage the feedbacks", "Version 1.0",
	            "urn:tos", "akashbonde@live.com", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	}

}
