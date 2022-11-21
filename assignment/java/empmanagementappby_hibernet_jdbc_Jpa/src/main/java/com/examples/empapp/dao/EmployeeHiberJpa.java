package com.examples.empapp.dao;

import java.util.ArrayList;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;

import com.examples.empapp.model.Employee;
import com.examples.empapp.utill.ConnectionHelper_jpa;

public class EmployeeHiberJpa implements EmployeeDao{
	
	private static EntityManagerFactory factory=ConnectionHelper_jpa.getfactory();

	@Override
	public boolean insert(Employee emp) {
		
		EntityManager entityManager = factory.createEntityManager();
		try {
			entityManager.getTransaction().begin();

			// Insert data into table by supplying the persistent object
			entityManager.persist(emp);

			System.out.println("\nEmployee inserted successfully with ID - " );

			entityManager.getTransaction().commit();
			return true;
		} catch (PersistenceException pe) {
			entityManager.getTransaction().rollback();
			pe.printStackTrace();
		}

		return false;
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

//	@Override
//	public boolean createEmployee(Employee emp) {
//		// TODO Auto-generated method stub
//		return false;
//	}

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
