/**
 * 
 */
package com.acheron.courseapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	
	@GetMapping("/courses/pages/{pages}/records/{records}")
	ResponseEntity<BrowseIndexResponse<Course>> getCourseWithPagination(@PathVariable("pages") int pages,
			@PathVariable("records") int records){
		
		logger.info("Courses");
		BrowseIndexResponse<Course> courses= courseService.getAllWithPagination(pages,records);
		System.out.println("running");
		return ResponseEntity.ok().body(courses);
	}
	
	@GetMapping("/courses/sorting/{attribute}")
	ResponseEntity<BrowseIndexResponse<Course>> getCourseWithSorting(@PathVariable("attribute") String attribute){
		
		logger.info("Courses");
		BrowseIndexResponse<Course> courses= courseService.getAllSorting(attribute);
		System.out.println("running");
		return ResponseEntity.ok().body(courses);
	}

}
