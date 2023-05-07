package com.nara.eps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nara.eps.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
