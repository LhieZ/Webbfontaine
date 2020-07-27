package com.webbfontaine.analysis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="commits")
public class Commits {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userName;
	@Column(columnDefinition="TEXT")
	private String message;
	private String timeline;
	private Long projectsId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTimeline() {
		return timeline;
	}
	public void setTimeline(String string) {
		this.timeline = string;
	}
	public Long getProjectsId() {
		return projectsId;
	}
	public void setProjectsId(Long projectsId) {
		this.projectsId = projectsId;
	}

	
}
