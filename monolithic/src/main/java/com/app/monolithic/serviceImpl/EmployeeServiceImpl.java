package com.app.monolithic.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.monolithic.entity.Employee;
import com.app.monolithic.entity.Project;
import com.app.monolithic.exception.ResourceNotFoundException;
import com.app.monolithic.payload.EmployeeDto;
import com.app.monolithic.repository.EmployeeRepository;
import com.app.monolithic.repository.ProjectRepository;
import com.app.monolithic.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository; 
	@Autowired
	private ProjectRepository projectRepository; 
	
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public EmployeeDto saveEmployee(Employee employee) {
		
		
		Project ProjectCode = projectRepository.findByProjectCode(employee.getEmployeeAssignedProjectCode());
		if(ProjectCode.equals(null)) {
			throw new ResourceNotFoundException(String.format("Requested employee doesnot have any project with Code : %d",employee.getEmployeeAssignedProjectCode() ));
		}
		Employee savedEmployee = employeeRepository.save(employee);
		Project findByProjectCode = projectRepository.findByProjectCode(savedEmployee.getEmployeeAssignedProjectCode());
		EmployeeDto empDto = new EmployeeDto();
		empDto.setId(employee.getId());
		empDto.setEmployeeName(employee.getEmployeeName());
		empDto.setEmployeeEmail(employee.getEmployeeEmail());
		empDto.setProjectCode(findByProjectCode.getProjectCode());
		empDto.setProjectName(findByProjectCode.getProjectName());
		empDto.setEmployeeBaseLocation(employee.getEmployeeBaseLocation());
		return empDto;
	}

	@Override
	public EmployeeDto getEmployeeById(long id) {
		Employee employee = employeeRepository.findById(id).get();
		Project findByProjectCode = projectRepository.findByProjectCode(employee.getEmployeeAssignedProjectCode());
		
		EmployeeDto empDto = new EmployeeDto();
		empDto.setId(employee.getId());
		empDto.setEmployeeName(employee.getEmployeeName());
		empDto.setEmployeeEmail(employee.getEmployeeEmail());
		empDto.setProjectCode(findByProjectCode.getProjectCode());
		empDto.setProjectName(findByProjectCode.getProjectName());
		empDto.setEmployeeBaseLocation(employee.getEmployeeBaseLocation());
		
		return empDto;
	}

}
