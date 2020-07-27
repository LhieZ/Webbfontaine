package com.webbfontaine.analysis.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Projects {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "projectsId", unique = true, nullable = false)
    private Long projectsId;
	private String name;
	private String commitUrl;
	
	@OneToMany
	@JoinColumn(name = "projectsId", referencedColumnName = "projectsId")
	private List<Commits> commitList;
	
	public Long getProjectsId() {
		return projectsId;
	}
	public void setProjectsId(Long projectsId) {
		this.projectsId = projectsId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCommitUrl() {
		return commitUrl;
	}
	public void setCommitUrl(String commitUrl) {
		this.commitUrl = commitUrl;
	}
	public List<Commits> getCommitList() {
		return commitList;
	}
	public void setCommitList(List<Commits> commitList) {
		this.commitList = commitList;
	}
		
}
