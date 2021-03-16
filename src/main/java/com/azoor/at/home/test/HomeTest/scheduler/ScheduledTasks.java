package com.azoor.at.home.test.HomeTest.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.azoor.at.home.test.HomeTest.service.ThirdPartyIssueConsumerService;

@Component
public class ScheduledTasks {
	@Autowired
	private ThirdPartyIssueConsumerService thirdPartyIssueConsumerService;

	public static final long timePeriod = 1000 * 60 * 5;

	@Scheduled(fixedRate = timePeriod)
	public void reportCurrentTime() {
		thirdPartyIssueConsumerService.consume();

	}
}