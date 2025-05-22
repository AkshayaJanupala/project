package com.project.users;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient

public class User3Application {

	public static void main(String[] args) {
		SpringApplication.run(User3Application.class, args);
	}

}
