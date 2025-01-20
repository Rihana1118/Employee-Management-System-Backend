package com.edu.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.Department;
import com.edu.dao.Employee;
import com.edu.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//  http://localhost:9090/saveEmployee
	
	@PostMapping("/saveEmployee")
		public Employee saveEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
		
	}
	
	//GetAllEmployees
	
   //  http://localhost:9090/getAllEmployees
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
		
	}
	
   //  http://localhost:9090/getEmployeeById/1
	
	@GetMapping("/getEmployeeById/{empid}")
	public Employee getEmployeeById(@PathVariable("empid") Integer employeeid) {
		return employeeService.getEmployeeById(employeeid);
		
	}
	
	 //  http://localhost:9090/deleteEmployeeById/1
	
		@DeleteMapping("/deleteEmployeeById/{empid}")
		public List<Employee> deleteEmployeeById(@PathVariable("empid") Integer employeeid) {
			 employeeService.deleteEmployeeById(employeeid);
			return getAllEmployees();
			
		}
		
		//update employee
		
		@PutMapping("/updateEmployeeById/{empid}")
		public Employee updateEmployeeById(@PathVariable("empid") Integer employeeid, @RequestBody Employee employee) {
			return employeeService.updateEmployeeById(employeeid,employee);
			
		}
		
		//update departmentid to employee
		// http://localhost:9090/updateDepartmentIdToEmployee/deptid/1/empid/1
		
		@PutMapping("/updateDepartmentIdToEmployee/deptid/{deptid}/empid/{empid}")
		public List<Department> updateDepartmentIdToEmployee(@PathVariable("deptid") Integer departmentid ,@PathVariable("empid") Integer employeeid) {
			return employeeService.updateDepartmentIdToEmployee(departmentid,employeeid);
			
		}
		
	}
