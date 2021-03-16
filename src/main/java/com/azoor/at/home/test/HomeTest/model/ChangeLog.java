package com.azoor.at.home.test.HomeTest.model;

import com.azoor.at.home.test.HomeTest.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ChangeLog {
	private int changeLogId;
	@JsonProperty("changed_on")
	private String changedOn;
	@JsonProperty("from_state")
	private Status fromState;
	@JsonProperty("to_state")
	private Status toState;

	public ChangeLog(int changeLogId, String changedOn, Status fromState, Status toState) {
		this.changeLogId = changeLogId;
		this.changedOn = changedOn;
		this.fromState = fromState;
		this.toState = toState;
	}

	public ChangeLog() {

	}

	public int getChangeLogId() {
		return changeLogId;
	}

	public void setChangeLogId(int changeLogId) {
		this.changeLogId = changeLogId;
	}

	public String getChangedOn() {
		return changedOn;
	}

	public void setChangedOn(String changedOn) {
		this.changedOn = changedOn;
	}

	public Status getFromState() {
		return fromState;
	}

	public void setFromState(Status fromState) {
		this.fromState = fromState;
	}

	public Status getToState() {
		return toState;
	}

	public void setToState(Status toState) {
		this.toState = toState;
	}

}
