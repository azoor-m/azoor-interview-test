package com.azoor.at.home.test.HomeTest.model;

import java.util.List;

import com.azoor.at.home.test.HomeTest.enums.Status;

public class StateSummary {
	private Status state;
	private int count;
	private List<ResponseIssue> issues;

	public StateSummary(Status state, int count, List<ResponseIssue> issues) {
		this.state = state;
		this.count = count;
		this.issues = issues;
	}

	public StateSummary() {

	}

	public Status getState() {
		return state;
	}

	public void setState(Status state) {
		this.state = state;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<ResponseIssue> getIssues() {
		return issues;
	}

	public void setIssues(List<ResponseIssue> issues) {
		this.issues = issues;
	}

}
