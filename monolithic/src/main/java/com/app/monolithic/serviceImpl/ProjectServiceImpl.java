package com.app.monolithic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.monolithic.entity.Project;
import com.app.monolithic.repository.ProjectRepository;
import com.app.monolithic.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Project getProjectByCode(long projectCode) {
		return projectRepository.findByProjectCode(projectCode);
	}

}
