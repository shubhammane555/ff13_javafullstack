package com.examples.empapp.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.examples.empapp.model.Employee;
import com.examples.empapp.service.ConnectionHelper;

public class EmployeeDaoImpl implements EmployeeDao{
	
	static Connection con = ConnectionHelper.createConnection();
	
 @Override
	public boolean insert(Employee emp) {
		
		try {
			PreparedStatement pstmt =  con.prepareStatement("INSERT INTO employees (name, age, designation, department, country) VALUES (?,?,?,?,?);  ");
				
				pstmt.setString(1, emp.getName());
			    pstmt.setInt(2, emp.getAge());
			    pstmt.setString(3, emp.getDesignation());
			    pstmt.setString(4, emp.getDepartment());
			    pstmt.setString(5, emp.getCountry());
			try {
				int i = pstmt.executeUpdate();
				System.out.println("Employee Inserted to Database");
				pstmt.close();
			}catch(Exception e){
				System.out.println("Error while inserting");
				e.printStackTrace();
			}
			
			return true ;
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Employee emp) {
		// TODO Auto-generated method stub
		try {
			Statement stmt = con.createStatement();
			String query = "UPDATE employees SET name = '" + emp.getName() + "', age = '" + emp.getAge() + "', department = '" + emp.getDepartment() + "', designation = '" + emp.getDesignation() + "', country = '" + emp.getCountry() + "' WHERE empId = " + emp.getEmpId() + ";";
			stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Updating Employee");
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(int empId) {
		// TODO Auto-generated method stub
		String q = "DELETE FROM employees WHERE Id ="+empId + ";" ; 
		try {
			Statement stmt = con.createStatement() ;
			stmt.execute(q);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}

	@Override
	public Employee viewEmp(int empId ) {
		// TODO Auto-generated method stub
		 
		
		try {
			PreparedStatement pstmt = con.prepareStatement( "SELECT * FROM employees WHERE ID = ? ;");
			pstmt.setInt(1, empId);
			ResultSet rs = pstmt.executeQuery();
			Employee emp = null ;
			if(rs.next()) {
				int id = rs.getInt("Id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String desgi = rs.getString("designation");
				String depart = rs.getString("department");
				String country = rs.getString("country");
				emp = new Employee(id , name , age,desgi,depart,country);
				
			}
			rs.close();
			pstmt.close();
			return emp ;
			
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM employees") ;
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("empId");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String desgi = rs.getString("designation");
				String depart = rs.getString("department");
				String country = rs.getString("country");
				Employee emp = new Employee(id , name , age,desgi,depart,country);
				employees.add(emp);
			}
			rs.close();
			pstmt.close();
			return (ArrayList<Employee>) employees ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	private int getEmployeeCountAgeGreaterThan(){
		
		String q = "SELECT COUNT(*) FROM employees where age >= 25 ;" ;
		
		int count ;
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(q);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				 count = rs.getInt(1);
				return count ;
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return 0 ;
	}
	
	private ArrayList<Integer> getEmployeeIdsAgeGreaterThan(){
		ArrayList<Integer> array = new ArrayList<>();
		String q = "SELECT empId FROM employees where age >= 25 ;" ;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(q);
			ResultSet rs = pstmt.executeQuery() ; 
			
			while(rs.next()) {
				array.add(rs.getInt("empId"));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return array ;
	}
	
	private Map<String,Integer> getEmployeeCountByDepartment(){
		Map<String, Integer> map = new HashMap<String, Integer>();
		String q = "SELECT department,COUNT(*) as count FROM employees GROUP BY department ;" ;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(q);
			ResultSet rs = pstmt.executeQuery() ; 
			while(rs.next()) {
				String department = rs.getString("department");
				int count = rs.getInt("count");
				
				map.put(department, count);
			}
			rs.close();
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		
		return map ;
		
		
		
	}
	private Map<String,Integer> getEmployeeCountByDepartmentOdered() {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		String q = "SELECT department,COUNT(*) as count FROM employees GROUP BY department ORDER BY department ;" ;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(q);
			ResultSet rs = pstmt.executeQuery() ; 
			while(rs.next()) {
				String department = rs.getString("department");
				int count = rs.getInt("count");
				map.put(department, count);
				
			}
			rs.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		
		return map ;
	}
	@Override
	public void statistics() {
		// TODO Auto-generated method stub
		
		System.out.println("No of employees older than twenty five years: "
				+ getEmployeeCountAgeGreaterThan());
		System.out.println("List employee IDs older than twenty five years: " + getEmployeeIdsAgeGreaterThan());
		System.out.println("Employee count by Department: " + getEmployeeCountByDepartment());
		System.out.println("Employee count by Department ordered: " + getEmployeeCountByDepartmentOdered());
	}
	@Override
	public void exit() {
		// TODO Auto-generated method stub
		try {
			con.close();
			System.out.println("All Connection Closed.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override 
	public void export() {
		try {
			String path = "C:\\Users\\hp\\Desktop\\New folder (3)\\empmanagementappby_jdbc\\output\\employee-output.txt";
			
			FileOutputStream fileOutputStream = new FileOutputStream(path,true);
			
			String q = "SELECT * FROM employees ; ";
			
			try {
				PreparedStatement pstmt = con.prepareStatement(q);
				ResultSet rs = pstmt.executeQuery();
				String rec = "" ;
				while(rs.next()){
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int age = rs.getInt("age");
					String desgi = rs.getString("designation");
					String depart = rs.getString("department");
					String country = rs.getString("country");
					
					 rec += id + "," + name + "," + age + ","
							+ desgi + "," + depart + "," + country + "\n" ;

					 System.out.println("Data Exported.");
				}
				try(OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8)) {
					outputStreamWriter.append(rec);
					outputStreamWriter.flush();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	

}