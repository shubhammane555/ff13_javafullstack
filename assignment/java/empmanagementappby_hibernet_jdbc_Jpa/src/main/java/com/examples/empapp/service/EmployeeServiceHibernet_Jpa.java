package com.examples.empapp.service;

import java.util.ArrayList;
import java.util.Map;

import com.examples.empapp.dao.EmployeeDao;
import com.examples.empapp.dao.EmployeeHiberDao;
import com.examples.empapp.dao.EmployeeHiberJpa;
import com.examples.empapp.model.Employee;

public class EmployeeServiceHibernet_Jpa implements EmployeeDao {
	
	private static EmployeeDao emphiberjpa1 =new EmployeeHiberJpa();

	@Override
	public boolean insert(Employee emp) {
		// TODO Auto-generated method stub
		return emphiberjpa1.insert(emp);
	}

	@Override
	public boolean update(Employee emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int empId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee viewEmp(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void statistics() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void export() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getEmployeeCountAgeGreaterThan(int i) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public String getEmployeeCountByDepartment() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public String getEmployeeCountByDepartmentOdered() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> getEmployeeCountByDepartment2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Object, Object> getEmployeeCountByDepartmentOdered1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmployeeCountByDepartment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Object, Object> getEmployeeCountByDepartment1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> getEmployeeCountByDepartmentOdered2() {
		// TODO Auto-generated method stub
		return null;
	}



}
