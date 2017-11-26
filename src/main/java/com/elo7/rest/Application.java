package com.elo7.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.elo7")
public class Application{
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
