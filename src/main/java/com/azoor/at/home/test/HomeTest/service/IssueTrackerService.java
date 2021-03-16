package com.azoor.at.home.test.HomeTest.service;

import com.azoor.at.home.test.HomeTest.model.Request;
import com.azoor.at.home.test.HomeTest.model.Response;

public interface IssueTrackerService {

	public Response getWeeklySummary(Request request);

}
