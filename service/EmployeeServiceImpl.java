package com.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Department;
import com.edu.dao.Employee;
import com.edu.repository.DepartmentRepository;
import com.edu.repository.EmployeeRespository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRespository employeeRespository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRespository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRespository.findAll();
	}

	@Override
	public Employee getEmployeeById(Integer employeeid) {
		// TODO Auto-generated method stub
		return employeeRespository.findById(employeeid).get();
	}

	@Override
	public void deleteEmployeeById(Integer employeeid) {
		// TODO Auto-generated method stub
		employeeRespository.deleteById(employeeid);
		
	}

	@Override
	public Employee updateEmployeeById(Integer employeeid, Employee employee) {
		// TODO Auto-generated method stub
		//Check Employee exists
		
		Employee empexists = employeeRespository.findById(employeeid).get();
		
		if(empexists != null) {
			if(employee.getEmployeename()!=null)
				empexists.setEmployeename(employee.getEmployeename());
			
			if(employee.getEmployeeemail()!=null)
				empexists.setEmployeeemail(employee.getEmployeeemail());
			
			if(employee.getEmployeejoindate() != null)
				empexists.setEmployeedob(employee.getEmployeedob());
			
			if(employee.getEmployeephone() != null)
				empexists.setEmployeephone(employee.getEmployeephone());
			
			if(employee.getEmployeesalary() != 0)
				empexists.setEmployeesalary(employee.getEmployeesalary());
			
			if(employee.getEmployeedob() != null)
				empexists.setEmployeedob(employee.getEmployeedob());
			
			if(employee.getEmployeejoindate() != null)
				empexists.setEmployeedob(employee.getEmployeedob());
		}
		return employeeRespository.save(empexists);
	}

	@Override
	public List<Department> updateDepartmentIdToEmployee(Integer departmentid, Integer employeeid) {
		// TODO Auto-generated method stub
		Department dob=departmentRepository.findById(departmentid).get();
		
		Employee eob = employeeRespository.findById(employeeid).get();
		
		eob.setDepartment(dob);
		 employeeRespository.save(eob);
		 return departmentRepository.findAll();
	}

}
