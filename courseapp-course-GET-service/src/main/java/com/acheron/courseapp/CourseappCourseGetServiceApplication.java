package com.acheron.courseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CourseappCourseGetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseappCourseGetServiceApplication.class, args);
	}

}
