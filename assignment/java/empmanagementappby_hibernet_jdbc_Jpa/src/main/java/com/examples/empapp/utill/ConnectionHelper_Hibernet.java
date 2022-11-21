package com.examples.empapp.utill;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.examples.empapp.model.Employee;
//import com.examples.empapp.model.Employee1;



public class ConnectionHelper_Hibernet {
	
	private static SessionFactory factory = null ;
	
	public static SessionFactory getFactory() {
		
		if(factory == null) {
			// STEP 1: Create Configuration
						Configuration config = new Configuration();
						// loads hibernate mapping configs from annotated class
						config.addAnnotatedClass(Employee.class);

						// STEP 2: Create SessionFactory
						factory = config.buildSessionFactory();
						System.out.println("Connected to databased - " + factory);
				
				
							return factory ;
		}
		
		
		return factory;
	}
	
}
