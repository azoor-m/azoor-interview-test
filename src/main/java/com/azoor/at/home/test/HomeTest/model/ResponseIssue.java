package com.azoor.at.home.test.HomeTest.model;

import com.azoor.at.home.test.HomeTest.enums.IssueType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseIssue {
	@JsonProperty("issue_id")
	private String issueId;
	private IssueType type;

	public ResponseIssue(String issueId, IssueType type) {
		this.issueId = issueId;
		this.type = type;
	}

	public ResponseIssue() {

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

}
