package com.azoor.at.home.test.HomeTest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {
	@JsonProperty("project_id")
	private String projectId;
	private List<Issue> issues;

	public Project(String projectId, List<Issue> issues) {
		this.projectId = projectId;
		this.issues = issues;
	}

	public Project() {

	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<Issue> getIssues() {
		return issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

}
