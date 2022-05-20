package com.skoti.learning.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skoti.learning.model.Employees;

@Component
public class EmployeeDao {

	public List<Employees> getAllEmployees() {
		return Arrays.asList(new Employees("shashi", "Hospet"), new Employees("shwe", "dvg"), new Employees("ved", "blore"));
		
	}

}
