package com.webbfontaine.analysis.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webbfontaine.analysis.domain.Commits;
import com.webbfontaine.analysis.domain.Projects;
import com.webbfontaine.analysis.service.DataService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/project")
public class DatasController {
	
	@Autowired
	private DataService dataService;

	@PostMapping("")
	public ResponseEntity<?> getProjectsAndSave(@RequestBody List<Projects> projectList, BindingResult result){
		List<Projects> projects = new ArrayList<>();
		projectList.stream().forEach(project -> {
			projects.add(project);
			dataService.saveProjects(project);
		});
		
		return new ResponseEntity<List<Projects>>(projects, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public Iterable<Projects> getAllProjects(){
		return dataService.findAllProjectsData();
	}
	
	@GetMapping("/{projectId}")
	public ResponseEntity<?> getProjectById(@PathVariable Long projectId){
		
		List<Commits> commits = dataService.findByProjectsId(projectId);
		return new ResponseEntity<List<Commits>>(commits, HttpStatus.OK);
	}
}
