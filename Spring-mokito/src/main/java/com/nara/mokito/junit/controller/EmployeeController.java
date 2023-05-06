package com.nara.mokito.junit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nara.mokito.junit.model.Employee;
import com.nara.mokito.junit.model.EmployeeResponse;
import com.nara.mokito.junit.repository.EmployeeRepository;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository; 
	
	@PostMapping(path = "/addEmployee")
	public EmployeeResponse addEmployee(@RequestBody(required = true) Employee employee) {
		employeeRepository.save(employee);
		return new EmployeeResponse(employee.getId()+" inserted Successfully", Boolean.TRUE);
	}
	
	@GetMapping(path="/getAllEmployees")
	public EmployeeResponse getAllEmployees() {
		List<Employee> empList = employeeRepository.findAll();
		return new EmployeeResponse("Record Count "+empList.size()+"::"+empList,  Boolean.TRUE);
	}
}
