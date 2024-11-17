package com.hstn.crud_rest.controller;

import com.hstn.crud_rest.entity.Employee;
import com.hstn.crud_rest.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model model) {
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees", employees);

		return "list-employees";
	}

	@GetMapping("addNewEmployee")
	public String addNewEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new-employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);

		return "redirect:/employees/list";
	}

	@GetMapping("updateEmloyee")
	public String formForUpdate(@RequestParam("employeeId") int employeeId, Model model) {
		Employee employee = employeeService.findById(employeeId);
		model.addAttribute("employee", employee);

		return "new-employee-form";
	}
}
