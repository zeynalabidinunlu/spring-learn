package com.zeynalabidin.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zeynalabidin.model.Employee;

@Configuration
public class AppConfig {

	@Bean
	public List<Employee> employeeList(){
		
		List<Employee> employeeList = new ArrayList<>();
		
		employeeList.add(new Employee("1","Zeynal","unlu"));
		employeeList.add(new Employee("2","Hacı Bayram","Akkurt"));
		employeeList.add(new Employee("3","Turgut Taha","Yılmaz"));
		employeeList.add(new Employee("4","Uğur","Nusretoğlu"));
		employeeList.add(new Employee("4","Uğur","Küçük"));

		return employeeList;
		
	}
}
