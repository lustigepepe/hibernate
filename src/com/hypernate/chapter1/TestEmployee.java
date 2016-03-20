package com.hypernate.chapter1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestEmployee {

	public static void main(String[] args) {
		// 
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Employee.class);
		config.configure("hibernate.cfg.xml");

		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		//
		session.beginTransaction();
		//
		Employee alex = new Employee();
		alex.setEmpId(100);
		alex.setEmpName("Alex Berry");
		alex.setEmpEmailAdress("alex@muhh.com");

		session.save(alex);
		// here start the saving
		session.getTransaction().commit();

	}

}
