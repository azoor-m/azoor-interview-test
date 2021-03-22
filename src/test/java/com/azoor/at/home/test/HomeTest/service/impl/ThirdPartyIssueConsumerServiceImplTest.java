package com.azoor.at.home.test.HomeTest.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThirdPartyIssueConsumerServiceImplTest {
	int yearOfTheWeek;
	String date;
	String key;
	
	@Autowired
	ThirdPartyIssueConsumerServiceImpl thirdPartyIssueConsumerService;

	@BeforeEach
	void setUp() throws Exception {
		yearOfTheWeek = 5;
		date = "2021-01-30 12:00pm UTC";
		key = "WEEK";
	}

	@Test
	void testProcessDate() {
		assertEquals(yearOfTheWeek, thirdPartyIssueConsumerService.processDate(date, key));
	}

}
