/**
 * 
 */
package com.acheron.courseapp.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.acheron.courseapp.model.Course;
import com.algolia.search.DefaultSearchClient;
import com.algolia.search.SearchClient;
import com.algolia.search.SearchIndex;
import com.algolia.search.models.indexing.BrowseIndexQuery;
import com.algolia.search.models.indexing.BrowseIndexResponse;
import com.algolia.search.models.indexing.Query;
import com.algolia.search.models.indexing.SearchResult;
import com.algolia.search.models.settings.IndexSettings;
import com.algolia.search.models.settings.SetSettingsResponse;

/**
 * @author JagannathSutar
 *	This repository class use to do operation with ALGOLIA database 
 */
@Repository
public class CourseRepositoryImpl implements ICourseRepository {
	SearchClient client=DefaultSearchClient.create("BWN0VYKP4E","0c805a3cf34b135916f08df31e635715");
	SearchIndex<Course> index = client.initIndex("course_index", Course.class);
	
	
	
	@Override
	public BrowseIndexResponse<Course> getAllWithPagination(int pages,int hitsPerPage) {
//		SetSettingsResponse pagingIndex= index.setSettings(
//				  new IndexSettings().setHitsPerPage(10)
//				); 
		
//		return index.search(
//				  new Query("query").setPage(hitsPerPage).getAttributesToRetrieve()
//				);
		
		  BrowseIndexResponse<Course> courses = index
                .browseFrom(new BrowseIndexQuery().setPage(pages).setHitsPerPage(hitsPerPage));
		  return courses;
	}
	@Override
	public BrowseIndexResponse<Course> getAllSorting(String attribute) {
		return null;
		
//		return index.setSettings(
//				  new IndexSettings().setReplicas(Collections.singleton(attribute)));
		
//		SetSettingsResponse replicaIndex=index.setSettings(
//		        new IndexSettings().setReplicas(Collections.singletonList("sorting"))
//		);
		
//		BrowseIndexResponse<Course> courses = index
//                .browseFrom(new BrowseIndexQuery().setSortFacetValuesBy(attribute));
//		
//		return courses;
		
//		Index<Course> replica_index = client.initIndex("products_virtual_price_desc", Contact.class);
//
//		// Both
//		replica_index.setSettings(
//		  new IndexSettings().setCustomRankingRanking(Arrays.asList(
//		    "desc(price)"
//		  ))
//		);
		
		
		
	}
	

	

}
