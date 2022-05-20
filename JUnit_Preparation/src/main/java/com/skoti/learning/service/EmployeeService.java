package com.skoti.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skoti.learning.dao.EmployeeDao;
import com.skoti.learning.model.Employees;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	public List<Employees> getAllEmployees() {
		return employeeDao.getAllEmployees();
	
	}

}
