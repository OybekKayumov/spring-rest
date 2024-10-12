package com.hstn.crud_rest.service;

import com.hstn.crud_rest.dao.EmployeeDAO;
import com.hstn.crud_rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	public Employee findEmployeeById(int id) {
		return employeeDAO.findEmployeeById(id);
	}

	@Override
	@Transactional
	public Employee save(Employee employees) {
		return employeeDAO.save(employees);
	}

	@Override
	@Transactional
	public void deleteEmployeeById(int id) {
		employeeDAO.deleteEmployeeById(id);
	}
}
