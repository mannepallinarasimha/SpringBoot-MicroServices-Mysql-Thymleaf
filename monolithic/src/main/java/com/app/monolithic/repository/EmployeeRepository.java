package com.app.monolithic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.monolithic.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
