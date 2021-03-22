package com.azoor.at.home.test.HomeTest.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.azoor.at.home.test.HomeTest.enums.IssueType;
import com.azoor.at.home.test.HomeTest.enums.Status;
import com.azoor.at.home.test.HomeTest.model.Request;
import com.azoor.at.home.test.HomeTest.model.Response;
import com.azoor.at.home.test.HomeTest.service.ThirdPartyIssueConsumerService;

@SpringBootTest
class IssueTrackerServiceImplTest {
	Request request;
	Response response;

	@Autowired
	IssueTrackerServiceImpl issueTrackerServiceImpl;

	@Autowired
	ThirdPartyIssueConsumerService thirdPartyIssueConsumerService;

	@BeforeEach
	void setUp() throws Exception {
		thirdPartyIssueConsumerService.consume();

		List<IssueType> types = new ArrayList<>();
		types.add(IssueType.bug);

		List<Status> statuses = new ArrayList<>();
		statuses.add(Status.deploy);

		request = new Request("project1", "2021W1", "2021W2", types, statuses);
	}

	@Test
	void testGetWeeklySummary() {
		assertEquals(2, issueTrackerServiceImpl.getWeeklySummary(request).getWeeklySummaries().size());
	}

}
