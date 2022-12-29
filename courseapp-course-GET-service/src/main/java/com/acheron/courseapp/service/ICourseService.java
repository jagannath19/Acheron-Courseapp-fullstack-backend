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
	
	public BrowseIndexResponse<Course> getAllWithPagination(int pages,int hitsPerPage);
	BrowseIndexResponse<Course> getAllSorting(String attribute);
	Course getById(String courseId);
	
}
