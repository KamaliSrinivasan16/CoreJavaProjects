package com.feedback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.feedback")
@EntityScan(basePackages="com.feedback")
public class UserFeebackApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserFeebackApplication.class, args);
	}

}
