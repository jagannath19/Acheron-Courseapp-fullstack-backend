/**
 * 
 */
package com.acheron.courseapp.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acheron.courseapp.model.Course;
import com.acheron.courseapp.repository.ICourseRepository;
import com.algolia.search.models.indexing.BrowseIndexResponse;
import com.algolia.search.models.indexing.SearchResult;

/**
 * @author JagannathSutar
 *
 */
@Service
public class CourseServiceImpl implements ICourseService {
	
	private ICourseRepository courseRepository;
	
	@Autowired
	public void setCourseRepository(ICourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}


	@Override
	public BrowseIndexResponse<Course> getAllWithPagination(int pages,int hitsPerPage) {
		
		return courseRepository.getAllWithPagination(pages,hitsPerPage);
	}

	@Override
	public BrowseIndexResponse<Course> getAllSorting(String attribute) {
		// TODO Auto-generated method stub
		return courseRepository.getAllSorting(attribute);
	}

	@Override
	public Course getById(String courseId) {
		return courseRepository.getById(courseId);
	}
	
	

}
