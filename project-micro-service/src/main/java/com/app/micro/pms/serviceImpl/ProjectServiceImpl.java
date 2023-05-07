package com.app.micro.pms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.micro.pms.entity.Project;
import com.app.micro.pms.repository.ProjectRepository;
import com.app.micro.pms.service.ProjectService;

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
