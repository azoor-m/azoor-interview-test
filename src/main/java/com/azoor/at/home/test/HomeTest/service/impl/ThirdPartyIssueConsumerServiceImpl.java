package com.azoor.at.home.test.HomeTest.service.impl;

/**
 * This class is used to consume the Issues list from third party API
 * and stored into the database of application side to faster process.
 * this consumer runs through a scheduler.
 */

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.azoor.at.home.test.HomeTest.entity.IssueTracker;
import com.azoor.at.home.test.HomeTest.model.Project;
import com.azoor.at.home.test.HomeTest.repository.IssueTrackerRepository;
import com.azoor.at.home.test.HomeTest.service.ThirdPartyIssueConsumerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ThirdPartyIssueConsumerServiceImpl implements ThirdPartyIssueConsumerService {
	@Autowired
	IssueTrackerRepository issueTrackerRepository;

	@Override
	public void consume() {
		try {
			//Read the Json file and convert into JSON object
			File file = new ClassPathResource("sample.json").getFile();
			ObjectMapper mapper = new ObjectMapper();
			Project project = mapper.readValue(file, Project.class);
			System.out.println(project);

			List<IssueTracker> issueTrackers = new ArrayList<>();

			//Processed the data and store into the database
			project.getIssues().parallelStream().forEach(issue -> {
				issue.getChangeLogs().parallelStream().forEach(chLog -> {
					issueTrackers.add(new IssueTracker(0, project.getProjectId(), issue.getIssueId(), issue.getCurrentState(), chLog.getToState(), issue.getType(), chLog.getChangedOn(),
							processDate(chLog.getChangedOn(), "WEEK"), processDate(chLog.getChangedOn(), "YEAR")));
				});
			});

			issueTrackerRepository.saveAll(issueTrackers);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private int processDate(String dateStr, String key) {
		int returnValue = 0;
		String date = dateStr.split(" ")[0];
		String time = dateStr.split(" ")[1].replace("pm", "");
		LocalDateTime dateObj= LocalDateTime.of(Integer.parseInt(date.split("-")[0]), Integer.parseInt(date.split("-")[1]), Integer.parseInt(date.split("-")[2]), 
				Integer.parseInt(time.split(":")[0]), Integer.parseInt(time.split(":")[1]));
		System.out.println(dateObj.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
		
		switch (key) {
		case "WEEK":
			returnValue = dateObj.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
			break;

		default:
			returnValue = dateObj.get(ChronoField.YEAR);
			break;
		}
		return returnValue;
	}

}
