package org.aadi.poc.libraryApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisCacheWithSpringbootGradleDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheWithSpringbootGradleDemoApplication.class, args);
	}

}