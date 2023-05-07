package com.app.monolithic.service;

import com.app.monolithic.entity.Project;

public interface ProjectService {
	public Project saveProject(Project project);
	public Project  getProjectByCode(long projectCode);
}
