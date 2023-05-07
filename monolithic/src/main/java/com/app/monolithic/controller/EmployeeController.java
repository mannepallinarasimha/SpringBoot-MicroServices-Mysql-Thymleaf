package com.app.monolithic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.monolithic.entity.Employee;
import com.app.monolithic.payload.EmployeeDto;
import com.app.monolithic.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired 
	private EmployeeService employeeService;
	
	@PostMapping
	public EmployeeDto saveEmployee(@RequestBody Employee employee ) {
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/{id}")
	public EmployeeDto getEmployeeById(@PathVariable("id") long id){
		return employeeService.getEmployeeById(id);
	}
}
