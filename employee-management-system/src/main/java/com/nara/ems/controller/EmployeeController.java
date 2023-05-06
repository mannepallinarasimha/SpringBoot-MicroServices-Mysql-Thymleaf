package com.nara.ems.controller;

import com.nara.ems.exception.ResourcenotFoundException;
import com.nara.ems.model.Employee;
import com.nara.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path = "/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //getAllEmployees
    @GetMapping(path = "/employees")
    public List<Employee> getallEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping(path = "/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping(path = "/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        Employee empById = employeeRepository.findById(id).orElseThrow(() -> new ResourcenotFoundException("Employee NOT Found in DB with Id :"+id));
        empById.setFirstName(employee.getFirstName());
        empById.setLastName(employee.getLastName());
        empById.setEmail(employee.getEmail());
        return ResponseEntity.ok(employeeRepository.save(empById));
    }

    @DeleteMapping(path = "/employees/{id}")
    public Map<String, Boolean> deleteEmployeeById(@PathVariable("id") Long id) {
        Employee empById = employeeRepository.findById(id).orElseThrow(() -> new ResourcenotFoundException("Employee NOT Found in DB with Id :"+id));
        employeeRepository.delete(empById);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping(path="/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourcenotFoundException("Employee NOT Found in DB with Id :"+id));
        return new ResponseEntity<Employee>( employee, HttpStatus.OK);
    }

}
