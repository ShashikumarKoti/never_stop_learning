package com.skoti.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skoti.learning.model.Employees;
import com.skoti.learning.service.EmployeeService;

@RestController
@RequestMapping("/v2")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;


	@GetMapping("/employees")
	public List<Employees> getEmployees() {
		return employeeService.getAllEmployees();
	}
}
