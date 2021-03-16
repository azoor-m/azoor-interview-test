package com.azoor.at.home.test.HomeTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azoor.at.home.test.HomeTest.model.Request;
import com.azoor.at.home.test.HomeTest.model.Response;
import com.azoor.at.home.test.HomeTest.service.IssueTrackerService;
import com.azoor.at.home.test.HomeTest.service.ThirdPartyIssueConsumerService;

@RestController
@RequestMapping("/v1/issues")
public class IssueTrackerController {
	
	@Autowired
	IssueTrackerService issueTrackerService;
	
	@Autowired
	ThirdPartyIssueConsumerService thirdPartyIssueConsumerService;
	
	@PostMapping(path = "/weekly", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Response> getWeeklySummaryReportData(@RequestBody Request request) {

		return new ResponseEntity<Response>(issueTrackerService.getWeeklySummary(request), HttpStatus.OK);
	}
	
	@PostMapping(path = "/load", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> loadData() {

		thirdPartyIssueConsumerService.consume();
		return new ResponseEntity<String>("{message:sucessfull}", HttpStatus.OK);
	}
	

}
