package com.azoor.at.home.test.HomeTest.model;

import java.util.List;

import com.azoor.at.home.test.HomeTest.enums.IssueType;
import com.azoor.at.home.test.HomeTest.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Issue {
	@JsonProperty("issue_id")
	private String issueId;
	private IssueType type;
	@JsonProperty("current_state")
	private Status currentState;
	@JsonProperty("changelogs")
	List<ChangeLog> changeLogs;

}
