package com.azoor.at.home.test.HomeTest.model;

import java.util.List;

import com.azoor.at.home.test.HomeTest.enums.IssueType;
import com.azoor.at.home.test.HomeTest.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Request {
	@JsonProperty("project_id")
	private String projectId;
	@JsonProperty("from_week")
	private String fromWeek;
	@JsonProperty("to_week")
	private String toWeek;
	private List<IssueType> types;
	private List<Status> status;

	public Request(String projectId, String fromWeek, String toWeek, List<IssueType> types, List<Status> status) {
		this.projectId = projectId;
		this.fromWeek = fromWeek;
		this.toWeek = toWeek;
		this.types = types;
		this.status = status;
	}

	public Request() {

	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getFromWeek() {
		return fromWeek;
	}

	public void setFromWeek(String fromWeek) {
		this.fromWeek = fromWeek;
	}

	public String getToWeek() {
		return toWeek;
	}

	public void setToWeek(String toWeek) {
		this.toWeek = toWeek;
	}

	public List<IssueType> getTypes() {
		return types;
	}

	public void setTypes(List<IssueType> types) {
		this.types = types;
	}

	public List<Status> getStatus() {
		return status;
	}

	public void setStatus(List<Status> status) {
		this.status = status;
	}

}
