/**
 * 
 */
package com.acheron.courseapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acheron.courseapp.model.Course;
import com.acheron.courseapp.repository.ICourseRepository;
import com.algolia.search.models.indexing.BrowseIndexResponse;
import com.algolia.search.models.indexing.IndicesResponse;

/**
 * @author JagannathSutar
 *	This is a service class
 */
@Service
public class CourseServiceImpl implements ICourseService {
	
	private ICourseRepository courseRepository;
	
	@Autowired
	public void setCourseRepository(ICourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}


	/**
	 *	@param pages and hits per page
	 *	@return Courses
	 *	This method use to get courses according to param
	 */
	@Override
	public List<Course> getAllWithPagination(int pages,int hitsPerPage) {
		
		return courseRepository.getAllWithPagination(pages,hitsPerPage);
	}

	/**
	 *	
	 */
	@Override
	public BrowseIndexResponse<Course> getAllSorting(String attribute) {
		// TODO Auto-generated method stub
		return courseRepository.getAllSorting(attribute);
	}

	/**
	 *	@param courseId
	 *	@return course
	 *	This method use to get a course object using courseid
	 */
	@Override
	public Course getById(String courseId) {
		return courseRepository.getById(courseId);
	}


	/**
	 *	@param Search data
	 *	@return list of courses
	 *	This method use to get the data using search data
	 */
	@Override
	public List<Course> getBySearch(String data) {
		return courseRepository.getBySearch(data);
	}


	@Override
	public long getLength() {
		return courseRepository.getlength();
	}
}
