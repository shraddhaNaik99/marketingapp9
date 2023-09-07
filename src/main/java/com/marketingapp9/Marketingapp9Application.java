package com.marketingapp9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.marketingapp9") // Add the package containing Lead1Service
public class Marketingapp9Application {

	public static void main(String[] args) {
		SpringApplication.run(Marketingapp9Application.class, args);
	}

}
