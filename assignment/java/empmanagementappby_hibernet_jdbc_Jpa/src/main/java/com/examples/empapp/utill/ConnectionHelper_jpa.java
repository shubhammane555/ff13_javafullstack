package com.examples.empapp.utill;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionHelper_jpa {
	private static EntityManagerFactory factory=null;
	
	public static EntityManagerFactory getfactory() {
		if(factory == null) {
		factory = Persistence.createEntityManagerFactory("com.examples.empapp.dao");
		System.out.println("Connected to databased - " + factory);
		return factory ;
		}
		return factory ;
	}

}
