package com.akshaj.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//The "spring-cloud-starter-gateway" dependency is used to build API gateways in Spring Boot applications.
// It provides a flexible way to route requests based on various criteria and also handles cross-cutting
// concerns such as security, resiliency, and monitoring.


@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
