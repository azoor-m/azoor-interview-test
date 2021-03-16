package com.azoor.at.home.test.HomeTest.model;

import com.azoor.at.home.test.HomeTest.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeLog {
	private int changeLogId;
	@JsonProperty("changed_on")
	private String changedOn;
	@JsonProperty("from_state")
	private Status fromState;
	@JsonProperty("to_state")
	private Status toState;

}
