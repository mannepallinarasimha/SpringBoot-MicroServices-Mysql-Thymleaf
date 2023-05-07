package com.nara.eps.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee", uniqueConstraints = @UniqueConstraint(columnNames = {"employeeEmail"}))
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String employeeName;
	
	@Column(nullable = false)
	private String employeeEmail;
	
	@Column(nullable = false)
	private long employeeAssignedProjectCode;
	
	@Column(nullable = false)
	private String employeeBaseLocation;
	
}
