package com.acheron.courseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author JagannathSutar
 * This is Eureka Registry main class
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class CourseappEurekaRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseappEurekaRegistryApplication.class, args);
	}

}
	