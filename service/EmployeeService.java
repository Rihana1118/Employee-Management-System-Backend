package com.edu.service;

import java.util.List;

import com.edu.dao.Department;
import com.edu.dao.Employee;

public interface EmployeeService {

public 	Employee saveEmployee(Employee employee);

public List<Employee> getAllEmployees();

public Employee getEmployeeById(Integer employeeid);

public void deleteEmployeeById(Integer employeeid);

public Employee updateEmployeeById(Integer employeeid, Employee employee);

public List<Department> updateDepartmentIdToEmployee(Integer departmentid, Integer employeeid);

}
