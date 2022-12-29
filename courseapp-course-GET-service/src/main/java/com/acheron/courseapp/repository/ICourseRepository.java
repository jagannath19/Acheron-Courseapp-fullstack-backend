/**
 * 
 */
package com.acheron.courseapp.repository;

import java.util.List;
import java.util.Set;

import com.acheron.courseapp.model.Course;
import com.algolia.search.models.indexing.BrowseIndexResponse;
import com.algolia.search.models.indexing.SearchResult;

/**
 * @author JagannathSutar
 * This interface use to do operation with the data base
 *
 */

public interface ICourseRepository {
	
	public BrowseIndexResponse<Course> getAllWithPagination(int pages,int hitsPerPage);
	BrowseIndexResponse<Course> getAllSorting(String attribute);
	Course getById(String courseId);
	
	
	
	
}
