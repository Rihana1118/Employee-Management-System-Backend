package com.edu.service;

import java.util.List;

import com.edu.dao.Department;

public interface DepartmentService {

public Department saveDepartment(Department department);

public List<Department> getAllDepartments();

public Department getDeprtmentById(Integer departmentid);

public List<Department> deleteDepartmentById(Integer departmentid);

public Department updateDepartmentById(Integer departmentid, Department department);

//public void deleteDepartmentById(Integer departmentid);

}
