package com.app.micro.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.micro.pms.entity.Project;
import com.app.micro.pms.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	@Autowired 
	private ProjectService projectService;
	
	@PostMapping
	public Project saveProject(@RequestBody Project project ) {
		return projectService.saveProject(project);
	}
	
	@GetMapping("/{project_code}")
	public Project  getProjectByProjectCode(@PathVariable("project_code") long projectCode){
		return projectService.getProjectByCode(projectCode);
	}
}
