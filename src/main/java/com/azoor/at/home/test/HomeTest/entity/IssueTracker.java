package com.azoor.at.home.test.HomeTest.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.azoor.at.home.test.HomeTest.enums.IssueType;
import com.azoor.at.home.test.HomeTest.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "issue_tracker")
@Data
@AllArgsConstructor
public class IssueTracker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entity_id")
	private int id;
	@Column(name = "project_id")
	private String projectId;
	@Column(name = "issue_id")
	private String issueId;
	@Column(name = "current_state")
	@Enumerated(EnumType.STRING)
	private Status currentState;
	@Enumerated(EnumType.STRING)
	private Status state;
	@Enumerated(EnumType.STRING)
	private IssueType type;
	@Column(name = "change_log_time")
	private String changeLogTime;
	private int weekOfTheYear;
	private int year;

}
