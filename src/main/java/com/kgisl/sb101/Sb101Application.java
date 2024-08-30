package com.kgisl.sb101;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy

public class Sb101Application {

	public static void main(String[] args) {
		SpringApplication.run(Sb101Application.class, args);
	}

}
