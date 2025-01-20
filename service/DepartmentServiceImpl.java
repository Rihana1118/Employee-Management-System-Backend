package com.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.edu.dao.Department;
import com.edu.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	//inject the refe of DepartmentRepository
   @Autowired
	private DepartmentRepository departmentRepository;
   
	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub //insert into department values(?,?)
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department getDeprtmentById(Integer departmentid) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(departmentid).get();
	}

	@Override
	public List<Department> deleteDepartmentById(Integer departmentid) {
		// TODO Auto-generated method stub
		 departmentRepository.deleteById(departmentid);
		 return departmentRepository.findAll();
	}

	@Override
	public Department updateDepartmentById(Integer departmentid, Department department) {
		// TODO Auto-generated method stub
		/* 
		  select * from department where departmentid="+departmentid;
		  department ->departname or department location
		 *  */
		Department dept1 = departmentRepository.findById(departmentid).get();
		
		if(dept1!=null) {
			if(department.getDepartmentname()!=null)
			     dept1.setDepartmentname(department.getDepartmentname()); //Sales
			if(department.getDepartmentlocation()!=null)
			     dept1.setDepartmentlocation(department.getDepartmentlocation()); //Bangalore
		}
		
		departmentRepository.save(dept1);
		
		return dept1;
	}

//	@Override
//	public void deleteDepartmentById(Integer departmentid) {
//		
//		departmentRepository.deleteById(departmentid);
//	}
	
	
	 

}
