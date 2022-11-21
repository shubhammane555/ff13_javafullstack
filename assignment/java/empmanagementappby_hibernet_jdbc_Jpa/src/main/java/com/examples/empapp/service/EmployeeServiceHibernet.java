package com.examples.empapp.service;

import java.io.Console;
import java.util.ArrayList;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.examples.empapp.dao.EmployeeDao;
import com.examples.empapp.dao.EmployeeHiberDao;
import com.examples.empapp.model.Employee;
//import com.examples.empapp.model.Employee1;
import com.examples.empapp.utill.ConnectionHelper_Hibernet;

public class EmployeeServiceHibernet implements EmployeeDao{
	
	private static EmployeeDao emphiber1 =new  EmployeeHiberDao();
	
	
	
	
	
	@Override
	public boolean insert(Employee emp) {
	
	return  emphiber1.insert(emp);
		
		
	}





	@Override
	public boolean update(Employee emp) {
		
		return emphiber1.update(emp);
	}





	@Override
	public boolean delete(int empId) {
		// TODO Auto-generated method stub
		return emphiber1.delete(empId);
	}





	@Override
	public Employee viewEmp(int empId) {
		
		return emphiber1.viewEmp(empId);
	}





	@Override
	public ArrayList<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		return emphiber1.getAllEmp();
	}





	@Override
	public void statistics() {
		// TODO Auto-generated method stub
		emphiber1.statistics();
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





	@Override
	public String getEmployeeCountByDepartment() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public String getEmployeeCountByDepartmentOdered() {
		// TODO Auto-generated method stub
		return null;
	}








	@Override
	public Map<Object, Object> getEmployeeCountByDepartmentOdered1() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public Map<String, Integer> getEmployeeCountByDepartmentOdered2() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public Map<Object, Object> getEmployeeCountByDepartment1() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public Map<String, Integer> getEmployeeCountByDepartment2() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
