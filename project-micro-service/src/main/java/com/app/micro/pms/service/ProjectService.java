package com.app.micro.pms.service;

import com.app.micro.pms.entity.Project;

public interface ProjectService {
	public Project saveProject(Project project);
	public Project  getProjectByCode(long projectCode);
}
