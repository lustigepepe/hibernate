package oi;

import java.util.EnumSet;
//import java.sql.*;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.*;
import org.hibernate.tool.hbm2ddl.SchemaExport;
//import org.hibernate.tool.schema.TargetType;
import org.hibernate.tool.schema.TargetType;

public class GeMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory;

		// new NativeData();
		// AnnotationConfiguration config = new AnnotationConfiguration();
		// config.addAnnotatedClass(PojoSql.class);
		// config.configure("hibernate.cfg.xml");
		// new SchemaExport().doExecution(action, needsJdbc, metadata,
		// serviceRegistry, targetDescriptor);;
		//
		// new StandardServiceRegistryBuilder();
		// MetadataSources metadata = new MetadataSources(new
		// StandardServiceRegistryBuilder());
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure()
				// configures
				// settings
				// from
				// hibernate.cfg.xml
				.build();
		try {
			Metadata ms = new MetadataSources(registry).buildMetadata();
			SchemaExport se = new SchemaExport();
			se.create(EnumSet.of(TargetType.DATABASE), ms);
			sessionFactory = ms.buildSessionFactory();
			Session session = sessionFactory.openSession();

			session.beginTransaction();

			System.out.println("Setup for Saving");

			PojoSql customer = new PojoSql();
			customer.setId(1);
			customer.setFirstName("jeahr");
			customer.setLastName("bbb");
			session.save(customer);

			List result = session.createQuery("from PojoSql").list();
			for (PojoSql event : (List<PojoSql>) result) {
				System.out.println("Event (" + event.getFirstName() + ") : " + event.getLastName());
			}
			//
			//
			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had
			// trouble building the SessionFactory
			// so destroy it manually.
			System.err.println("Trouble with sesseionFactory:" + e.getMessage());
			StandardServiceRegistryBuilder.destroy(registry);
		}

		// MetadataSources metadata = new MetadataSources(
		// new
		// StandardServiceRegistryBuilder().loadProperties("hibernate.cfg.xml").build());
		//
		//
		// EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.STDOUT);
		//
		// SchemaExport export = new SchemaExport();
		//
		// export.setDelimiter(";");
		// export.setFormat(true);
		//
		// export.createOnly(targetTypes, metadata.buildMetadata());

		// export.setDelimiter(";");
		// export.setFormat(true);
		//
		// export.createOnly(targetTypes, metadata.buildMetadata());

		// Configuration configuration = new Configuration();
		// System.out.println("CFG and hbm files loaded successfully.");//just
		// to test
		// configuration.configure("hibernate.cfg.xml");
		// SessionFactory factory = configuration.buildSessionFactory(new
		// StandardServiceRegistryBuilder().configure().build());
		//
		// Session session = factory.openSession();
		//
		// Transaction tx = session.getTransaction();
		// tx.begin();

		// System.out.println("Setup for Saving");
		//
		// PojoSql customer = new PojoSql();
		// customer.setId(1);
		// customer.setFirstName("jeahr");
		// customer.setLastName("bbb");

		// Query qu = session.createQuery("select pitt FROM CUSTOMER");

		// session.get(PojoSql.class,);

		//
		// session.save(customer);
		// session.flush();
		////
		// tx.commit();
		// session.close();
		// System.out.println("Done");

	}
}
