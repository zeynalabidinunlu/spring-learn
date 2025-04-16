package com.zeynalabidin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeynalabidin.model.Employee;
import com.zeynalabidin.services.EmployeeService;

@RestController
@RequestMapping("/rest/api")
public class RestEmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(path = "/employee-list")
	public List<Employee> getAllEmployeeList() {
	return	employeeService.getAllEmployeeList();
		
	}

}
