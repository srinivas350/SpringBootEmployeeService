package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entity.Department;
import com.example.entity.Employee;

@Service
public interface EmployeeService {
	
	public Employee saveEmployee(Employee emp);
	public List<Employee> getAllEmployees();
	public Optional<Employee> getEmployee(int empId);
	public List<Department> getDepartment(String dept);

}
