package com.nara.mokito.junit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nara.mokito.junit.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
