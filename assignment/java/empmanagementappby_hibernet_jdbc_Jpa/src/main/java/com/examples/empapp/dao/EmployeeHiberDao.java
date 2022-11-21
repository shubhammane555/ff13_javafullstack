package com.examples.empapp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.examples.empapp.model.Employee;
import com.examples.empapp.utill.ConnectionHelper_Hibernet;

public class EmployeeHiberDao implements EmployeeDao{
	
	private static SessionFactory factory=ConnectionHelper_Hibernet.getFactory();
	
	
	
	
	
	@Override
	public boolean insert(Employee emp) {
	
		Session session=null;
		Transaction tnx = null;
		Integer id = -1;

		try  {
			 session = factory.openSession();
			tnx = session.beginTransaction();
				
			// Insert data into table by supplying the persistent object
			 session.save(emp);

			System.out.println("\nEmployee inserted successfully with ID - " );

			tnx.commit();
			
		} catch (HibernateException he) {
			tnx.rollback();
			he.printStackTrace();
		}finally {
			session.close();
		}

		return false;
		
		
	}





	@Override
	public boolean update(Employee emp) {
		
		Transaction tnx = null ;
		Session session = null ;

			try {
				session = factory.openSession();
				tnx = session.beginTransaction();
				session.update(emp);
			  
				tnx.commit();
				return true ;
			} catch (HibernateException he) {
				tnx.rollback();
				he.printStackTrace();
			}finally {
				session.close();
			}

		return false;
	}





	@Override
	public boolean delete(int empId) {
		// TODO Auto-generated method stub
		Transaction tnx = null ;
		Session session = null ;

			try {
				session = factory.openSession();
				tnx = session.beginTransaction();
				Employee emp = viewEmp(empId);
				session.delete(emp);
			  
				tnx.commit();
				return true ;
			} catch (HibernateException he) {
				tnx.rollback();
				he.printStackTrace();
			}finally {
				session.close();
			}

		return false;
	}





	@Override
	public Employee viewEmp(int empId) {
		
		Transaction tnx = null ;
		Session session = null ;

try {
	session = factory.openSession();
	tnx = session.beginTransaction();
	
	
	 Employee emp=session.get(Employee.class, empId);

  
	tnx.commit();
	return emp ;
} catch (HibernateException he) {
	tnx.rollback();
	he.printStackTrace();
}finally {
	session.close();
}
return null ;
	
	}





	@Override
	public ArrayList<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		Transaction tnx = null ;
		Session session = null ;

			try {
				session = factory.openSession();
				tnx = session.beginTransaction();
				
				ArrayList<Employee> empall = (ArrayList<Employee>) session.createQuery("From Employee").list();
			
			  
				tnx.commit();
				return empall ;
			} catch (HibernateException he) {
				tnx.rollback();
				he.printStackTrace();
			}finally {
				session.close();
			}
			return null ;
	}





	@Override
	public void statistics() {
		// TODO Auto-generated method stub
		System.out.println("No of employees older than thirty years: "
				+ getEmployeeCountAgeGreaterThan().size());
		System.out.println("List employee IDs older than thirty years: " + getEmployeeIdsAgeGreaterThan());
		System.out.println("Employee count by Department: " + getEmployeeCountByDepartment());
		System.out.println("Employee count by Department ordered: " + getEmployeeCountByDepartmentOdered());
				
			}
	private ArrayList<Employee> getEmployeeCountAgeGreaterThan(){
		ArrayList<Employee> list = new ArrayList<>() ;
		
		Transaction tnx = null ;
		Session session = null ;

			try {
				session = factory.openSession();
				tnx = session.beginTransaction();
				list = (ArrayList<Employee>) session.createNativeQuery("SELECT * FROM Employee Where age > 25", Employee.class).list();
				
			  
				tnx.commit();
				return list ;
			} catch (HibernateException he) {
				tnx.rollback();
				he.printStackTrace();
			}finally {
				session.close();
			}
			return null ;
		
		
		
	}
	private List<Integer> getEmployeeIdsAgeGreaterThan(){
		List<Integer> list = new ArrayList<>() ;
		
		Transaction tnx = null ;
		Session session = null ;
		try {
			session = factory.openSession();
			tnx = session.beginTransaction();
			ArrayList<Employee> empList = getEmployeeCountAgeGreaterThan() ;
			list = empList.stream().map( emp -> emp.getEmpId()).toList();
		  
			tnx.commit();
			return list ;
		} catch (HibernateException he) {
			tnx.rollback();
			he.printStackTrace();
		}finally {
			session.close();
		}
		return null ;
	}
	
	public Map<Object,Object> getEmployeeCountByDepartment1(){
		Map<Object,Object> map = new HashMap<Object,Object>();
		Transaction tnx = null ;
		Session session = null ;
		try {
			session = factory.openSession();
			tnx = session.beginTransaction();
			String hql = "SELECT department, COUNT(*) from Employee GROUP BY department";
			List<Object> list = session.createQuery(hql).list();
			for(int i=0; i<list.size(); i++) {
				Object[] row = (Object[]) list.get(i);
				map.put(row[0],row[1]);
			}
			return map ;
		} catch (HibernateException he) {
			tnx.rollback();
			he.printStackTrace();
		}finally {
			session.close();
		}
	
		return null ;
	}
	public Map<Object,Object> getEmployeeCountByDepartmentOdered1(){
		
		Map<Object,Object> map = new LinkedHashMap<Object,Object>();
		Transaction tnx = null ;
		Session session = null ;
		try {
			session = factory.openSession();
			tnx = session.beginTransaction();
			String hql = "SELECT department, COUNT(*) from Employee GROUP BY department ORDER BY COUNT(*)";
			List<?> list = session.createQuery(hql).list();
			for(int i=0; i<list.size(); i++) {
				Object[] row = (Object[]) list.get(i);
				map.put(row[0],row[1]);
			}
			return map ;
		} catch (HibernateException he) {
			tnx.rollback();
			he.printStackTrace();
		}finally {
			session.close();
		}
	
		return null ;
		
	}






	@Override
	public void export() {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void exit() {
		// TODO Auto-generated method st
		
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
	public Map<String, Integer> getEmployeeCountByDepartment2() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public String getEmployeeCountByDepartmentOdered() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public Map<String, Integer> getEmployeeCountByDepartmentOdered2() {
		// TODO Auto-generated method stub
		return null;
	}









//
//	@Override
//	public Map<String, Integer> getEmployeeCountByDepartment() {
//		// TODO Auto-generated method stub
//		return null;
//	}


























	
}