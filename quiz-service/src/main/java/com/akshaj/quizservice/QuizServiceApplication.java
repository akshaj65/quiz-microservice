package com.akshaj.quizservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//OpenFeign is a declarative REST client that simplifies writing web service clients in Spring Boot applications.
// It provides pluggable annotation support, including Feign annotations, JAX-RS annotations, and Spring MVC annotations. With OpenFeign,
// you can define interfaces that represent the API of the service you want to consume, and Feign will generate the implementation for you.
// This allows you to call the service without writing any code for calling the service, other than the interface definition.

// openFeign can work with Spring Cloud LoadBalancer, which provides load balancing capabilities for Spring Cloud applications

@SpringBootApplication
@EnableFeignClients
public class QuizServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizServiceApplication.class, args);
	}

}
