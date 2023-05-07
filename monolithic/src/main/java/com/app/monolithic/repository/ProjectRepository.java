package com.app.monolithic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.monolithic.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

	Project findByProjectCode(long employeeAssignedProjectCode);
}
