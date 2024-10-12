package com.hstn.crud_rest.dao;

import com.hstn.crud_rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

	List<Employee> findAll();

	Employee findEmployeeById(int id);

	Employee save(Employee employees);

	void deleteEmployeeById(int id);
}
