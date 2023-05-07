package com.app.micro.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.micro.pms.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

	Project findByProjectCode(long employeeAssignedProjectCode);
}
