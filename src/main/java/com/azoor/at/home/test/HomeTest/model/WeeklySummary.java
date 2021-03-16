package com.azoor.at.home.test.HomeTest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeeklySummary {
	private String week;
	@JsonProperty("state_summaries")
	private List<StateSummary> stateSummaries;

}
