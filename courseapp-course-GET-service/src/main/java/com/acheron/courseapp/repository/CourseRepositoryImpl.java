/**
 * 
 */
package com.acheron.courseapp.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.acheron.courseapp.model.Course;
import com.algolia.search.DefaultSearchClient;
import com.algolia.search.SearchClient;
import com.algolia.search.SearchIndex;
import com.algolia.search.models.indexing.BrowseIndexQuery;
import com.algolia.search.models.indexing.BrowseIndexResponse;
import com.algolia.search.models.indexing.IndicesResponse;
import com.algolia.search.models.indexing.Query;

/**
 * @author JagannathSutar
 *	This repository class use to do operation with ALGOLIA database 
 */
@Repository
public class CourseRepositoryImpl implements ICourseRepository {
	SearchClient client=DefaultSearchClient.create("BWN0VYKP4E","0c805a3cf34b135916f08df31e635715");
	SearchIndex<Course> index = client.initIndex("course_index", Course.class);
	
	
	
	/**
	 *  @param pages and hits per pages
	 *	This method use to get courses from database according to pages and hits per pages 
	 */
	@Override
	public List<Course> getAllWithPagination(int pages,int hitsPerPage) {
		  return index
                .browseFrom(new BrowseIndexQuery().setPage(pages).setHitsPerPage(hitsPerPage)).getHits();
	}
	
	
	/**
	 *	
	 */
	@Override
	public BrowseIndexResponse<Course> getAllSorting(String attribute) {
		return null;	
	}
	
	
	/**
	 *	@param courseId
	 *	@return course
	 *	This method use to get a course using courseid from databse
	 */
	@Override
	public Course getById(String courseId) {
		return index.getObject(courseId);
	}
	
	
	/**
	 *	@param search data
	 *	@return courses
	 *	This method use to get courses from database
	 */
	@Override
	public List<Course> getBySearch(String data) {
		// TODO Auto-generated method stub
		return index.search(new Query(data)).getHits();
	}


	
	@Override
	public long getlength() {
		return client.listIndices().get(0).getEntries();
	}
	

	

}
