package com.nara.eps.service;

import com.nara.eps.entity.Employee;
import com.nara.eps.payload.EmployeeDto;

public interface EmployeeService {

	public EmployeeDto saveEmployee(Employee employee);
	public EmployeeDto getEmployeeById(long id);
}
