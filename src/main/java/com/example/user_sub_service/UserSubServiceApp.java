package com.example.user_sub_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class UserSubServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(UserSubServiceApp.class, args);
		log.info("Go to -> :{}", "http://localhost:8080");
	}

}
