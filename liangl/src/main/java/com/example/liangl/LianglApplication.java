package com.example.liangl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan
@CrossOrigin
public class LianglApplication {

	public static void main(String[] args) {
		SpringApplication.run(LianglApplication.class, args);
	}
}
