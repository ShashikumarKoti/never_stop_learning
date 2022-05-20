package com.skoti.learning.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import com.skoti.learning.model.Employees;
import com.skoti.learning.service.EmployeeService;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)  //this is needed to use @BeforeAll annotation
class EmployeeControllerTest {

	@InjectMocks
	private EmployeeController employeeController;
	
	@Mock
	private EmployeeService empService;
	
	@Spy
	HashMap<String, Integer> hashMap;
	
	@Mock
	HashMap<String, Integer> hashMap2;
	
	@BeforeEach
    public void before() {
        System.out.println("called before each test method");
    }
	
	@BeforeAll
    public void beforeAll() {
        System.out.println("called once before all test methods are executed");
    }
	
	
	@Test
	void testHashMap_withSpy()
	{
	  hashMap.put("A", 10);  //here actual hashmap put method is  called  since we are using Spy, Hence size of hashhmap is 1
	   
	  Mockito.verify(hashMap, times(1)).put("A", 10);
	  Mockito.verify(hashMap, times(0)).get("A");
	   
	  assertEquals(1, hashMap.size());
	  assertEquals(10, (Integer) hashMap.get("A"));
	}
	
	@Test
	void testHashMap_withMock()
	{
	  hashMap2.put("A", 10);  //here actual hashmap put method is NOT called , since we are using Mock, Hence size of hashmap is zero
	   
	  Mockito.verify(hashMap2, times(1)).put("A", 10);
	  Mockito.verify(hashMap2, times(0)).get("A");
	   
	  assertEquals(0, hashMap2.size());
	}
	
	@Test
	void testGetAllEmployees() {
		Employees emp1 = new Employees("sk", "hpt");
		Employees emp2 = new Employees("shwe", "dvg");
		List<Employees> emps = new ArrayList<>();
		emps.add(emp1);
		emps.add(emp2);

		when(empService.getAllEmployees()).thenReturn(emps);

		assertThat(employeeController.getEmployees().size()).isEqualTo(2);
	} 

}
