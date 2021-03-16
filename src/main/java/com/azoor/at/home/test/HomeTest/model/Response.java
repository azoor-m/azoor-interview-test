package com.azoor.at.home.test.HomeTest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
	@JsonProperty("project_id")
	private String projectId;
	@JsonProperty("weekly_summaries")
	private List<WeeklySummary> weeklySummaries;

	public Response(String projectId, List<WeeklySummary> weeklySummaries) {
		this.projectId = projectId;
		this.weeklySummaries = weeklySummaries;
	}

	public Response() {

	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<WeeklySummary> getWeeklySummaries() {
		return weeklySummaries;
	}

	public void setWeeklySummaries(List<WeeklySummary> weeklySummaries) {
		this.weeklySummaries = weeklySummaries;
	}

}
