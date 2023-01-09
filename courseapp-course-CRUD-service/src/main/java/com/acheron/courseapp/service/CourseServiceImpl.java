/**
 * 
 */
package com.acheron.courseapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acheron.courseapp.model.Course;
import com.acheron.courseapp.repository.ICourseRepository;

/**
 * @author JagannathSutar
 *	This class is a service class
 */
@Service
public class CourseServiceImpl implements ICourseService {
	
	private ICourseRepository courseRepository;
	
	/**
	 * @param courseRepository
	 */
	@Autowired
	public void setCourseRepository(ICourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	/**
	 *	Method use to add a course
	 *	A Course is taking as parameter
	 */
	@Override
	public void addCourse(Course course) {
		courseRepository.addCourse(course);
	}

	/**
	 *	Method use to update a course
	 *	A Course object is taking as a parameter
	 */
	@Override
	public void updateCourse(Course course) {
		courseRepository.updateCourse(course);
	}

	/**
	 *	Method use to delete a course
	 *	Course id is taking as a parameter
	 */
	@Override
	public void deleteCourse(String courseId) {
		courseRepository.deleteCourse(courseId);
	}

	

		

}
