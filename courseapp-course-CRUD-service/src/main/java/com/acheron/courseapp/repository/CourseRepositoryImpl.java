/**
 * 
 */
package com.acheron.courseapp.repository;

import org.springframework.stereotype.Repository;

import com.acheron.courseapp.model.Course;
import com.algolia.search.DefaultSearchClient;
import com.algolia.search.SearchClient;
import com.algolia.search.SearchIndex;

/**
 * @author JagannathSutar
 *	This repository class use to do operation with ALGOLIA database 
 */
@Repository
public class CourseRepositoryImpl implements ICourseRepository {

	
	
	SearchClient client=DefaultSearchClient.create("BWN0VYKP4E","0c805a3cf34b135916f08df31e635715");
	SearchIndex<Course> index = client.initIndex("course_index", Course.class);
	
	
	/**
	 *	This method uses to add course in database 
	 *	Taking a Course parameter
	 */
	@Override
	public void addCourse(Course course) {
		index.saveObject(course).waitTask();
		
	}
	
	
	/**
	 *	THis method use to update a course in database
	 *	Taking a Course parameter
	 */
	@Override
	public void updateCourse(Course course) {
		index.saveObject(course).waitTask();
	}
	
	/**
	 *	This method use to delete the course from the database
	 *	Taking a courseId as parameter
	 */
	@Override
	public void deleteCourse(String courseId) {
		index.deleteObject(courseId);
	}

}
