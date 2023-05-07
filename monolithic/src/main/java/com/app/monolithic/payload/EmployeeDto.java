package com.app.monolithic.payload;

import lombok.Data;

@Data
public class EmployeeDto {

	private long id;
	private String employeeName;
	private String employeeEmail;
	private String employeeBaseLocation;
	private long projectCode;
	private String projectName;
}
