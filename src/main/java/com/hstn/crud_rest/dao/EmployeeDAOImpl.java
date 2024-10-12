//package com.hstn.crud_rest.dao;
//
//import com.hstn.crud_rest.entity.Employee;
//import jakarta.persistence.EntityManager;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class EmployeeDAOImpl implements EmployeeDAO {
//
//	private EntityManager entityManager;
//
//	public EmployeeDAOImpl(EntityManager entityManager) {
//		this.entityManager = entityManager;
//	}
//
//	@Override
//	public List<Employee> findAll() {
//		return entityManager.createQuery("from Employee", Employee.class).getResultList();
//	}
//
//	@Override
//	public Employee findEmployeeById(int id) {
//
//		Employee employee = entityManager.find(Employee.class, id);
//		return employee;
//	}
//
//	@Override
//	public Employee save(Employee employees) {
//		// add or update
//		Employee newEmployee = entityManager.merge(employees);
//		return newEmployee;
//	}
//
//	@Override
//	public void deleteEmployeeById(int id) {
//		Employee employee = entityManager.find(Employee.class, id);
//		entityManager.remove(employee);
//	}
//}
