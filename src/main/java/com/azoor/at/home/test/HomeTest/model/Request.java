package com.azoor.at.home.test.HomeTest.model;

import java.util.List;

import com.azoor.at.home.test.HomeTest.enums.IssueType;
import com.azoor.at.home.test.HomeTest.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Request {
	@JsonProperty("project_id")
	private String projectId;
	@JsonProperty("from_week")
	private String fromWeek;
	@JsonProperty("to_week")
	private String toWeek;
	private List<IssueType> types;
	private List<Status> status;
	
}
