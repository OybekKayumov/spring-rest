package com.hstn.crud_rest.rest;

//import com.hstn.crud_rest.dao.EmployeeDAO;
import com.hstn.crud_rest.entity.Employee;
import com.hstn.crud_rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	//* before services
//	private EmployeeDAO employeeDAO;
//
//	@Autowired
//	public EmployeeRestController(EmployeeDAO employeeDAO) {
//		this.employeeDAO = employeeDAO;
//	}

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/emps")
	public List<Employee> findAll() {
		//return employeeDAO.findAll();
		return employeeService.findAll();
	}

	@GetMapping("/emps/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {

		Employee employee = employeeService.findById(employeeId);
		if (employee == null) {
			throw new RuntimeException("Employee ID " + employeeId + " not found");
		} else {
			return employee;
		}
	}

	@PostMapping("/emps")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		return employeeService.save(employee);
	}

	@PutMapping("/emps")
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee updatedEmployee = employeeService.save(employee);
		return updatedEmployee;
	}

	@DeleteMapping("/emps/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if (employee == null) {
			throw new RuntimeException("Employee ID " + employeeId + " not found");
		} else {
			employeeService.deleteEmployeeById(employeeId);
		}

		return "Deleted Employee ID " + employee.toString();
	}
}
