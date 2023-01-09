package com.acheron.courseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author JagannathSutar
 *	Cloud Gateway main class
 */
@SpringBootApplication
@EnableEurekaClient
public class CourseappCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseappCloudGatewayApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RouteLocator customRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("courseService", ps->ps.path("/course-serv/**").uri("lb://COURSE-SERVICE"))
				.build();
	}

}
