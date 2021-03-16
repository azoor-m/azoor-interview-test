package com.azoor.at.home.test.HomeTest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeeklySummary {
	private String week;
	@JsonProperty("state_summaries")
	private List<StateSummary> stateSummaries;

	public WeeklySummary(String week, List<StateSummary> stateSummaries) {
		this.week = week;
		this.stateSummaries = stateSummaries;
	}

	public WeeklySummary() {

	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public List<StateSummary> getStateSummaries() {
		return stateSummaries;
	}

	public void setStateSummaries(List<StateSummary> stateSummaries) {
		this.stateSummaries = stateSummaries;
	}

}
