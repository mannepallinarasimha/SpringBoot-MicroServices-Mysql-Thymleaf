package com.app.monolithic.service;

import com.app.monolithic.entity.Employee;
import com.app.monolithic.payload.EmployeeDto;

public interface EmployeeService {

	public EmployeeDto saveEmployee(Employee employee);
	public EmployeeDto getEmployeeById(long id);
}
