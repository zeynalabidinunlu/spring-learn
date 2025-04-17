package com.zeynalabidin.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zeynalabidin.model.Employee;
import com.zeynalabidin.model.UpdateEmployeeRequest;

@Repository
public class EmployeeRepository {

	@Autowired
	private List<Employee> employeeList;

	public List<Employee> getAllEmployeeList() {

		return employeeList;
	}

	public Employee getEmployeeById(String id) {
		Employee findEmployee = null;
		for (Employee employee : employeeList) {
			if (id.equals(employee.getId())) {
				findEmployee = employee;
				break;

			}
		}
		return findEmployee;

	}

	public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
		List<Employee> employeeWithParams = new ArrayList<>();
		if (firstName == null && lastName == null) {
			return employeeList;
		}
		for (Employee employee : employeeList) {
			if (employee.getName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)) {
				employeeWithParams.add(employee);
			}

			if (firstName != null && lastName == null) {
				if (employee.getName().equalsIgnoreCase(firstName)) {
					employeeWithParams.add(employee);
				}
			}
			if (lastName != null && firstName == null) {
				employeeWithParams.add(employee);
			}
		}
		return employeeWithParams;
	}

	public Employee saveEmployee(Employee newEmployee) {
		employeeList.add(newEmployee);

		return newEmployee;
	}

	public boolean deleteEmployee(String id) {

		Employee deleteEmployee = null;
		for (Employee employee : employeeList) {
			if (id.equals(employee.getId())) {
				deleteEmployee = employee;
				break;
			}
		}
		if (deleteEmployee == null) {
			return false;
		}
		employeeList.remove(deleteEmployee);
		return true;
	}

	private Employee findEmployeeById(String id) {
		Employee findEmployee = null;
		for (Employee employee : employeeList) {
			if (employee.getId().equals(id)) {

				return employee;
			}
		}
		return findEmployee;
	}

	public Employee updateEmployee(String id, UpdateEmployeeRequest request) {
		Employee findEmployee = findEmployeeById(id);
		if (findEmployee != null) {
			deleteEmployee(id);

			Employee uptadetEmployee = new Employee();

			uptadetEmployee.setId(id);
			uptadetEmployee.setName(request.getFirstName());
			uptadetEmployee.setName(request.getLastName());
			employeeList.add(uptadetEmployee);

			return uptadetEmployee;
		}
		return null;
	}

}
