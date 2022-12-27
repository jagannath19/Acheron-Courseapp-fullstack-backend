package com.acheron.courseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CourseappCourseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseappCourseServiceApplication.class, args);
	}

}
