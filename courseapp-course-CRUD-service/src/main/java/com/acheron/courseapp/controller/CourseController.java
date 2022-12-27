/**
 * 
 */
package com.acheron.courseapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acheron.courseapp.model.Course;
import com.acheron.courseapp.service.ICourseService;
import com.algolia.search.models.indexing.BrowseIndexResponse;

/**
 * @author JagannathSutar
 *
 */
@RestController
@RequestMapping("course-service")
@CrossOrigin("http://localhost:4200")
public class CourseController {
	private Logger logger = LoggerFactory.getLogger(CourseController.class);

	private ICourseService courseService;

	/**
	 * @param courseService authowire ICourseService
	 */
	@Autowired
	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	/**
	 * @param course
	 * @return http status for addCourse controller for addCourse
	 * Allow role for only ADMIN
	 * 
	 */
	@PostMapping("/addCourse")
	ResponseEntity<Void> addCourse(@RequestBody Course course) {
		

		logger.info("Adding one Course " + course);
		courseService.addCourse(course);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}

	/**
	 * @param course
	 * @return http status for updateCourse
	 * Use for update the course fee using course id
	 */
	
	@PutMapping("/updateCourse")
	ResponseEntity<Void> updateCourse(@RequestBody Course course) {
		

		
		courseService.updateCourse(course);
		
		
		return ResponseEntity.ok().build();
	}

	/**
	 * @param couseId
	 * Allow role for only ADMIN
	 */
	@DeleteMapping("/deleteCourse/{courseId}")
	void deleteCourse(@PathVariable("courseId") String couseId) {
		logger.info("Course deleted");
		courseService.deleteCourse(couseId);

	}

	/**
	 * @param courseId
	 * @return One course object
	 * Allow role for only ADMIN
	 */
	@GetMapping("/course/{courseId}")
	ResponseEntity<Course> getCourseById(@PathVariable("courseId") String courseId) {
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "get course by Id");
		return ResponseEntity.ok().headers(header).body(courseService.getById(courseId));
	}
	
	

}