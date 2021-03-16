package com.azoor.at.home.test.HomeTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.azoor.at.home.test.HomeTest.entity.IssueTracker;

@Repository
public interface IssueTrackerRepository extends JpaRepository<IssueTracker, Integer> {
	
	@Query(value  = "SELECT * FROM ISSUE_TRACKER WHERE " +
	"project_id =:project_id "+
	"AND type in(:types) "+
	"AND current_state in(:statuses) "+
	"AND year =:year "+
	"AND week_of_the_year >=:from_week AND week_of_the_year <=:to_week ORDER BY week_of_the_year desc",
    nativeQuery = true)
	List<Object[]> getWeeklySunnaryData(@Param("project_id") String projectId, @Param("year") Integer year
			, @Param("from_week") Integer fromWeek
			, @Param("to_week") Integer toWeek
			, @Param("types") List<String> types
			, @Param("statuses") List<String> statuses);
	

}
