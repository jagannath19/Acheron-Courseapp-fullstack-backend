/**
 * 
 */
package com.acheron.courseapp.repository;

import java.util.List;

import com.acheron.courseapp.model.Course;
import com.algolia.search.models.indexing.BrowseIndexResponse;
import com.algolia.search.models.indexing.IndicesResponse;

/**
 * @author JagannathSutar
 * This interface use to do operation with the data base
 *
 */

public interface ICourseRepository {
	
	public List<Course> getAllWithPagination(int pages,int hitsPerPage);
	BrowseIndexResponse<Course> getAllSorting(String attribute);
	Course getById(String courseId);
	List<Course> getBySearch(String data);
	long getlength();
	
	
	
	
}
