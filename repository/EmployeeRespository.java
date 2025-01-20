package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.dao.Employee;
import com.edu.service.EmployeeService;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee,Integer>{

	
	
	
}
