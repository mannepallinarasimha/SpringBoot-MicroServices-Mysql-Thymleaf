package com.nara.ems;

import com.nara.ems.model.Employee;
import com.nara.ems.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class EmployeeManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}

	private EmployeeRepository employeeRepository;

	public EmployeeManagementSystemApplication(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public void run(String... args) throws Exception {
//		Employee employee = new Employee("Narasimha","Mannepalli", "narasiha@gmail.com");
//		Employee employee1 = new Employee("Priyanka","Mannepalli", "Priyanka@gmail.com");
//		Employee employee2 = new Employee("Satya","Mannepalli", "Satya@gmail.com");
//		List<Employee> empList = Arrays.asList(employee, employee1, employee2);
//		employeeRepository.saveAll(empList);
	}
}
