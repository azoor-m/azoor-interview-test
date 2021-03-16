package com.azoor.at.home.test.HomeTest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.azoor.at.home.test.HomeTest.enums.IssueType;
import com.azoor.at.home.test.HomeTest.enums.Status;

@Entity
@Table(name = "issue_tracker")
public class IssueTracker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "entity_id")
	private int id;
	@Column(name = "project_id")
	private String projectId;
	@Column(name = "issue_id")
	private String issueId;
	@Column(name = "current_state")
	@Enumerated(EnumType.STRING)
	private Status currentState;
	@Enumerated(EnumType.STRING)
	private Status state;
	@Enumerated(EnumType.STRING)
	private IssueType type;
	@Column(name = "change_log_time")
	private String changeLogTime;
	private int weekOfTheYear;
	private int year;

	public IssueTracker() {

	}

	public IssueTracker(int id, String projectId, String issueId, Status currentState, Status state, IssueType type, String changeLogTime, int weekOfTheYear, int year) {
		this.id = id;
		this.projectId = projectId;
		this.issueId = issueId;
		this.currentState = currentState;
		this.state = state;
		this.type = type;
		this.changeLogTime = changeLogTime;
		this.weekOfTheYear = weekOfTheYear;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public Status getCurrentState() {
		return currentState;
	}

	public void setCurrentState(Status currentState) {
		this.currentState = currentState;
	}

	public Status getState() {
		return state;
	}

	public void setState(Status state) {
		this.state = state;
	}

	public IssueType getType() {
		return type;
	}

	public void setType(IssueType type) {
		this.type = type;
	}

	public String getChangeLogTime() {
		return changeLogTime;
	}

	public void setChangeLogTime(String changeLogTime) {
		this.changeLogTime = changeLogTime;
	}

	public int getWeekOfTheYear() {
		return weekOfTheYear;
	}

	public void setWeekOfTheYear(int weekOfTheYear) {
		this.weekOfTheYear = weekOfTheYear;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
