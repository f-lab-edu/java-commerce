package com.f_lab.java_commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JavaCommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaCommerceApplication.class, args);
	}

}
