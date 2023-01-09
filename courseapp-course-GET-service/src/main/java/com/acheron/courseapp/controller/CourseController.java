/**
 * 
 */
package com.acheron.courseapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acheron.courseapp.model.Course;
import com.acheron.courseapp.service.ICourseService;
import com.algolia.search.models.indexing.BrowseIndexResponse;
import com.algolia.search.models.indexing.IndicesResponse;

/**
 * @author JagannathSutar
 * This is a controller class
 *
 */
@RestController
@RequestMapping("course-api-all")
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
	 * @param pages
	 * @param records
	 * @return Courses 
	 * Allowed roles for everyone
	 */
	@PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_EDITOR','ROLE_MEMBER')")
	@GetMapping("/courses/pages/{pages}/records/{records}")
	ResponseEntity<List<Course>> getCourseWithPagination(@PathVariable("pages") int pages,
			@PathVariable("records") int records){
		
		logger.info("Courses");
		List<Course> courses= courseService.getAllWithPagination(pages,records);
		System.out.println("running");
		return ResponseEntity.ok().body(courses);
	}
	
	/**
	 * @param attribute
	 * @return 
	 */
	@GetMapping("/courses/sorting/{attribute}")
	ResponseEntity<BrowseIndexResponse<Course>> getCourseWithSorting(@PathVariable("attribute") String attribute){
		
		logger.info("Courses");
		BrowseIndexResponse<Course> courses= courseService.getAllSorting(attribute);
		System.out.println("running");
		return ResponseEntity.ok().body(courses);
	}
	
	/**
	 * @param courseId
	 * @return a single course object
	 */
	@PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_EDITOR','ROLE_MEMBER')")
	@GetMapping("/course/{courseId}")
	ResponseEntity<Course> getCourseById(@PathVariable("courseId") String courseId) {
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "get course by Id");
		return ResponseEntity.ok().headers(header).body(courseService.getById(courseId));
	}
	
	/**
	 * @param search data
	 * @return Courses according to data
	 */
	@PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_EDITOR','ROLE_MEMBER')")
	@GetMapping("/search/{data}")
	ResponseEntity<List<Course>> getBySearch(@PathVariable("data") String data) {
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "get course by data");
		return ResponseEntity.ok().headers(header).body(courseService.getBySearch(data));
	}
	
	@PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_EDITOR','ROLE_MEMBER')")
	@GetMapping("/length")
	ResponseEntity<Long> getLength() {
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "get course by data");
		return ResponseEntity.ok().headers(header).body(courseService.getLength());
	}

}