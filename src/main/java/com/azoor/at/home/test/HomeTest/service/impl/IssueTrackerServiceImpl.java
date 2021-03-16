package com.azoor.at.home.test.HomeTest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azoor.at.home.test.HomeTest.enums.IssueType;
import com.azoor.at.home.test.HomeTest.enums.Status;
import com.azoor.at.home.test.HomeTest.model.Request;
import com.azoor.at.home.test.HomeTest.model.Response;
import com.azoor.at.home.test.HomeTest.model.ResponseIssue;
import com.azoor.at.home.test.HomeTest.model.StateSummary;
import com.azoor.at.home.test.HomeTest.model.WeeklySummary;
import com.azoor.at.home.test.HomeTest.repository.IssueTrackerRepository;
import com.azoor.at.home.test.HomeTest.service.IssueTrackerService;

@Service
public class IssueTrackerServiceImpl implements IssueTrackerService {

	@Autowired
	IssueTrackerRepository issueTrackerRepository;
	
	@Override
	public Response getWeeklySummary(Request request) {
		Response response = new Response();
		List<String> types = request.getTypes().stream().map(type -> type.name()).collect(Collectors.toList());
		List<String> statuses = request.getStatus().stream().map(status -> status.name()).collect(Collectors.toList());
		List<Object[]> rows = issueTrackerRepository.getWeeklySunnaryData(request.getProjectId(), Integer.parseInt(request.getFromWeek().split("W")[0]),
				Integer.parseInt(request.getFromWeek().split("W")[1]), Integer.parseInt(request.getToWeek().split("W")[1]), types, statuses);
		
		response.setProjectId(request.getProjectId());
		
		if (rows == null || rows.isEmpty()) {
			return response;
		}
		//0= entity_id, 1=change_log_time, 2=current_state, 3=issue_id, 4=project_id, 5=state, 6, type, 7=week_of_the_year, 8=year
		List<WeeklySummary> weeklySummaries = new ArrayList<WeeklySummary>();
		List<StateSummary> stateSummaries = null;
		List<ResponseIssue> issues = null;
		int week = 0;
		String status = "";
		int issueCount = 0;
		boolean newWeekFound = false;
		boolean newStateFound = false;
		
		for (Object[] row : rows) {
			if(week == 0 || week != (Integer)row[7]) {
				newWeekFound = true;
				status = "";
				week = (Integer)(row[7]);
			} else {
				newWeekFound = false;
			}
			
			if(newWeekFound) {
				stateSummaries = new ArrayList<StateSummary>();
			}
			
			if(status.isEmpty() || !status.equals((String) row[2])) {
				newStateFound = true;
				status = (String) row[2];
			} else {
				newStateFound = false;
			}
			
			if(newStateFound) {
				issues = new ArrayList<ResponseIssue>();
				issueCount = 0;
			}
			
			issues.add(new ResponseIssue((String) row[3], IssueType.valueOf((String) row[6])));
			issueCount++;
			
			if(!newStateFound) {				
				stateSummaries.add(new StateSummary(Status.valueOf(status), issueCount, issues));
			}
			
			if(!newWeekFound && !newStateFound) {
				weeklySummaries.add(new WeeklySummary(row[8]+"W"+row[7], stateSummaries));
			}
		}
		response.setWeeklySummaries(weeklySummaries);
		
		return response;
	}

}
