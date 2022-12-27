/**
 * 
 */
package com.acheron.courseapp.service;

import java.util.List;

import com.acheron.courseapp.model.Course;
import com.algolia.search.models.indexing.BrowseIndexResponse;
import com.algolia.search.models.indexing.SearchResult;

/**
 * @author JagannathSutar
 *
 */
public interface ICourseService {
	void addCourse(Course course);
	
	void updateCourse(Course course);
	
	void deleteCourse(String courseId);
	
	Course getById(String courseId);
	List<Course> getAll();


	public BrowseIndexResponse<Course> getAllWithPagination(int pages,int hitsPerPage);
	BrowseIndexResponse<Course> getAllSorting(String attribute);
	
	
}
