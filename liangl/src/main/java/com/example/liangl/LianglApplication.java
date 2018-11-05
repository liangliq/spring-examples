package com.example.liangl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.example.liangl"})
public class LianglApplication {

	public static void main(String[] args) {
		SpringApplication.run(LianglApplication.class, args);
	}
}
