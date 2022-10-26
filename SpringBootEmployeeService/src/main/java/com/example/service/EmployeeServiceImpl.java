package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.entity.Department;
import com.example.entity.Employee;
import com.example.repositories.EmployeeRepostiory;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeRepostiory repo;
	@Autowired
	RestTemplate template;
	@Override
	public Employee saveEmployee(Employee emp) {
		Employee employee=repo.save(emp);
		
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList=repo.findAll();
		return empList;
	}

	@Override
	public Optional<Employee> getEmployee(int empId) {
		Optional<Employee> emp=repo.findById(empId);
		return emp;
	}

	@Override
	public List<Department> getDepartment(String dept) {
		List<Department> departments=(List<Department>) template.getForObject("http://localhost:8081/dept/getDept/{"+dept+"}", Department.class);
		return departments;
	}
	

}
