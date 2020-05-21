package com.ccssoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderMain8080 {
	public static void main(String[] args) {
		SpringApplication.run(OrderMain8080.class, args);
	}
}
