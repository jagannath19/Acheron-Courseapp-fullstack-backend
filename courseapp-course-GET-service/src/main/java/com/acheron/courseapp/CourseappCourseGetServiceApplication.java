package com.acheron.courseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = ReactiveUserDetailsServiceAutoConfiguration.class)
@EnableDiscoveryClient
public class CourseappCourseGetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseappCourseGetServiceApplication.class, args);
	}

}
