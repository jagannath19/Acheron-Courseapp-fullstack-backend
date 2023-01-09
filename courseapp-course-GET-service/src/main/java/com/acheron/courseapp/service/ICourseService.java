/**
 * 
 */
package com.acheron.courseapp.service;

import java.util.List;

import com.acheron.courseapp.model.Course;
import com.algolia.search.models.indexing.BrowseIndexResponse;
import com.algolia.search.models.indexing.IndicesResponse;

/**
 * @author JagannathSutar
 *
 */
public interface ICourseService {
	
	public List<Course> getAllWithPagination(int pages,int hitsPerPage);
	BrowseIndexResponse<Course> getAllSorting(String attribute);
	Course getById(String courseId);
	List<Course> getBySearch(String data);
	
	long getLength();
	
}
