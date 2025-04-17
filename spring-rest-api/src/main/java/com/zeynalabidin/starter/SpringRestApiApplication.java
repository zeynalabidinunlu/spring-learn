package com.zeynalabidin.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;


//@ComponentScan(basePackages= {"com.zeynalabidin"})
@EntityScan(basePackages = {"com.dataJpa"})
@ComponentScan(basePackages= {"com.dataJpa"})
@EnableJpaRepositories(basePackages = {"com.dataJpa"})
@SpringBootApplication
public class SpringRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApiApplication.class, args);
	}

}
