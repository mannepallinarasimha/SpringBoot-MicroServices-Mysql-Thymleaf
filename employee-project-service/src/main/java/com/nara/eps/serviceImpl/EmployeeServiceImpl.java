package com.nara.eps.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.nara.eps.entity.Employee;
import com.nara.eps.feignClient.ProjectFeign;
import com.nara.eps.payload.EmployeeDto;
import com.nara.eps.payload.Project;
import com.nara.eps.repository.EmployeeRepository;
import com.nara.eps.service.EmployeeService;

import feign.Response;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ProjectFeign projectFeign;

	@Override
	public EmployeeDto saveEmployee(Employee employee) {
		EmployeeDto empDto= null;
		try {
			Employee savedEmployee = employeeRepository.save(employee);
			Response response = projectFeign.getProjectByProjectCode(savedEmployee.getEmployeeAssignedProjectCode());
			System.out.println("Response from Feign Client::: **********************" + response);
			String body = response.body().toString();

			Project fromJson = new Gson().fromJson(body, Project.class);

			empDto = new EmployeeDto();
			empDto.setId(employee.getId());
			empDto.setEmployeeName(employee.getEmployeeName());
			empDto.setEmployeeEmail(employee.getEmployeeEmail());
			empDto.setProjectCode(fromJson.getProjectCode());
			empDto.setProjectName(fromJson.getProjectName());
			empDto.setEmployeeBaseLocation(employee.getEmployeeBaseLocation());
			return empDto;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return empDto;
	}

	@Override
	public EmployeeDto getEmployeeById(long id) {
		Employee employee = employeeRepository.findById(id).get();
		Response response = projectFeign.getProjectByProjectCode(employee.getEmployeeAssignedProjectCode());
		String body = response.body().toString();
		Project fromJson = new Gson().fromJson(body, Project.class);
		EmployeeDto empDto = new EmployeeDto();
		empDto.setId(employee.getId());
		empDto.setEmployeeName(employee.getEmployeeName());
		empDto.setEmployeeEmail(employee.getEmployeeEmail());
		empDto.setProjectCode(fromJson.getProjectCode());
		empDto.setProjectName(fromJson.getProjectName());
		empDto.setEmployeeBaseLocation(employee.getEmployeeBaseLocation());

		return empDto;
	}

}
