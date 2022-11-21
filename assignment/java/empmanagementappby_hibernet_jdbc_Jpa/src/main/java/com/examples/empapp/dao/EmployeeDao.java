package com.examples.empapp.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.examples.empapp.model.Employee;

public interface EmployeeDao {

	public boolean insert(Employee emp);
	
	public boolean update(Employee emp);
	
    public boolean delete(int empId);
	
	public Employee viewEmp(int empId);
	
	public ArrayList<Employee> getAllEmp();
	
	public void statistics() ;
	
	public void export() ;
	public void exit();

	public String getEmployeeCountAgeGreaterThan(int i);

//	public String getEmployeeCountByDepartment();  

	public Map<Object, Object> getEmployeeCountByDepartmentOdered1();
	public Map<String, Integer> getEmployeeCountByDepartmentOdered2();
	public String getEmployeeCountByDepartment();
	
	public Map<Object, Object> getEmployeeCountByDepartment1();
	public Map<String, Integer> getEmployeeCountByDepartment2();
	
	public String getEmployeeCountByDepartmentOdered();


}
