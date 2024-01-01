package com.concordia.microservices.QualitySettingsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QualitySettingsServiceApplication {

	public static void main(String[] args) {
		System.setProperty("spring.application.name", "qualitySettings-service");
		System.setProperty("spring.config.import", "optional:configserver:http://localhost:8888");
		SpringApplication.run(QualitySettingsServiceApplication.class, args);
	}

}
