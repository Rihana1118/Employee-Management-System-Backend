package com.edu.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer departmentid;
	
//	@NotEmpty(message = "Enter Department name")
//	@Column(nullable = false,length = 50)
	@NotEmpty(message = "Enter department name")
private String departmentname;
	
	@NotEmpty(message = "Enter  Department Location")
	@Column(nullable = false,length = 50)
private String departmentlocation;
	
	
	@OneToMany(mappedBy = "department")
	List<Employee> employeelist=new ArrayList<Employee>();
	
public Department() {
	super();
	// TODO Auto-generated constructor stub
}
public Department( String departmentname, String departmentlocation) {
	super();
	this.departmentname = departmentname;
	this.departmentlocation = departmentlocation;
}

public Integer getDepartmentid() {
	return departmentid;
}
public void setDepartmentid(Integer departmentid) {
	this.departmentid = departmentid;
}
public String getDepartmentname() {
	return departmentname;
}
public void setDepartmentname(String departmentname) {
	this.departmentname = departmentname;
}
public String getDepartmentlocation() {
	return departmentlocation;
}
public void setDepartmentlocation(String departmentlocation) {
	this.departmentlocation = departmentlocation;
}


public List<Employee> getEmployeelist() {
	return employeelist;
}
public void setEmployeelist(List<Employee> employeelist) {
	this.employeelist = employeelist;
}
@Override
public String toString() {
	return "Department [departmentid=" + departmentid + ", departmentname=" + departmentname + ", departmentlocation="
			+ departmentlocation + "]";
}
}
