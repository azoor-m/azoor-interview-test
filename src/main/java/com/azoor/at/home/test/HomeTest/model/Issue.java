package com.azoor.at.home.test.HomeTest.model;

import java.util.List;

import com.azoor.at.home.test.HomeTest.enums.IssueType;
import com.azoor.at.home.test.HomeTest.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Issue {
	@JsonProperty("issue_id")
	private String issueId;
	private IssueType type;
	@JsonProperty("current_state")
	private Status currentState;
	@JsonProperty("changelogs")
	List<ChangeLog> changeLogs;

	public Issue(String issueId, IssueType type, Status currentState, List<ChangeLog> changeLogs) {
		this.issueId = issueId;
		this.type = type;
		this.currentState = currentState;
		this.changeLogs = changeLogs;
	}

	public Issue() {

	}

	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public IssueType getType() {
		return type;
	}

	public void setType(IssueType type) {
		this.type = type;
	}

	public Status getCurrentState() {
		return currentState;
	}

	public void setCurrentState(Status currentState) {
		this.currentState = currentState;
	}

	public List<ChangeLog> getChangeLogs() {
		return changeLogs;
	}

	public void setChangeLogs(List<ChangeLog> changeLogs) {
		this.changeLogs = changeLogs;
	}

}
