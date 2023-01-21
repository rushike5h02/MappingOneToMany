package com.onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		
		User user = new User();

		// pass the value through constructor
		Policy policy1 = new Policy("P1", "Car Insurance", "Active", user);

		Policy policy2 = new Policy("P2", "Bike Insurance", "Active", user);

		Set<Policy> set = new HashSet<Policy>();
		set.add(policy1);
		set.add(policy2);

		user.setPolicy(set);
		user.setName("rushikesh");
		user.setEmail("rushikesh@gmail.com");

		session.save(user);
		session.save(policy1);
		session.save(policy2);
		
		System.out.println("Insertion Succesfull");

		transaction.commit();
		session.close();
		sessionFactory.close();




	}

}
