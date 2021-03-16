package com.azoor.at.home.test.HomeTest.model;

import java.util.List;

import com.azoor.at.home.test.HomeTest.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateSummary {
	private Status state;
	private int count;
	private List<ResponseIssue> issues;

}
