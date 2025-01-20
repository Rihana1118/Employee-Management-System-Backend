package com.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.Department;
import com.edu.service.DepartmentService;

@RestController
public class DepartmentController {
	
//Inject the ref of DepermentService
	
	@Autowired
	private DepartmentService departmentService;
	
	//save department
//used to insert new record ->@PostMapping
	//delete by id > @DeleteMapping
	//update by id ->@PutMapping
	//get the records -> GetMapping 
	
	/*   http://localhost:9090/saveDepartment  */
	
	@PostMapping("/saveDepartment")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		return departmentService.saveDepartment(department);
		
	}
	
	//fetch data from deparment
	/*  select * from department ->return type is list*/
	
	/*   http://localhost:9090/getAllDepartments  */
	
	@GetMapping("/getAllDepartments")
	public List<Department> getAllDepartments(){
		return departmentService.getAllDepartments();
		
	}
	
	//get record by id
	/* select * from department where departmentid=?  */
	
	// http://localhost:9090/getDeprtmentById/1
	
	@GetMapping("/getDeprtmentById/{deptid}")
	public Department getDeprtmentById(@PathVariable("deptid") Integer departmentid) {
		
		System.out.println("department id="+departmentid);
		return departmentService.getDeprtmentById(departmentid);
	}
	
	//deleteby id
	//DeleteMapping
	
	// http://localhost:9090/deleteDepartmentById/1
	
//	@DeleteMapping("/deleteDepartmentById/{deptid}")
//	public String deleteDepartmentById(@PathVariable("deptid") Integer departmentid) {
//		departmentService.deleteDepartmentById(departmentid);
//		return "Department with id="+ departmentid +" is deleted";
//		
//	}
//	
	// http://localhost:9090/deleteDepartmentById/1
	@DeleteMapping("/deleteDepartmentById/{deptid}")
	public List<Department> deleteDepartmentById(@PathVariable("deptid") Integer departmentid) {
		return departmentService.deleteDepartmentById(departmentid);
		
	}
	
	//update department , for update use @PutMapping
	
		/* for update record we need send department object, and department id */
		 /* @RequestBody and @PathVaraiable  */
	
	//http://localhost:9090/updateDepartmentById/2
		@PutMapping("/updateDepartmentById/{deptid}")
		public Department updateDepartmentById(@PathVariable("deptid") Integer departmentid,@RequestBody Department department ) {
			return departmentService.updateDepartmentById(departmentid,department);
			
		}
	
}
