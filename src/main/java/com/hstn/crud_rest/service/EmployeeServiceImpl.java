package com.hstn.crud_rest.service;

//import com.hstn.crud_rest.dao.EmployeeDAO;
import com.hstn.crud_rest.dao.EmployeeRepo;
import com.hstn.crud_rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepo employeeRepo;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@Override
	public List<Employee> findAll() {
		//return employeeRepo.findAll();
		return employeeRepo.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int id) {
		// employee might not be present, so we need to use Optional
		Optional<Employee> employee = employeeRepo.findById(id);
		Employee newEmployee = null;
		if (employee.isPresent()) {
			newEmployee = employee.get();
		} else {
			throw new RuntimeException("Employee not found with id: " + id);
		}
		return newEmployee;
	}

	@Override
	//@Transactional
	public Employee save(Employee employees) {
		return employeeRepo.save(employees);
	}

	@Override
	//@Transactional
	public void deleteEmployeeById(int id) {
		employeeRepo.deleteById(id);
	}
}
