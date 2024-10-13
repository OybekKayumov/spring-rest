package com.hstn.crud_rest.dao;

import com.hstn.crud_rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "emps")
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
