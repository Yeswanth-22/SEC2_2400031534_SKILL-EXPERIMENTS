package com.klu.main;


import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.klu.entity.Product;


public class ProductApp {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		String pname = null;
		String description = null;
		double price = 0.0;
		int quantity = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number of rows:");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.println("enter product name:");
			pname = sc.nextLine();
			
			System.out.println("enter a description:");
			description = sc.nextLine();
			
			System.out.println("enter a price:");
			price = sc.nextDouble();
			sc.nextLine();
			
			System.out.println("enter a quantity:");
			quantity = sc.nextInt();
			sc.nextLine();
			
			Product p=new Product();
			p.setPname(pname);
			p.setDescription(description);
			p.setPrice(price);
			p.setQuantity(quantity);
			s.persist(p);
		}
		tx.commit();
		s.close();
		
		String hql1="from Product where id=:id";
		s=sf.openSession();
		Query<Product> q1 = s.createQuery(hql1, Product.class);
		q1.setParameter("id",1);
		List<Product> l1=q1.getResultList();
		System.out.println("reteriving product using a id:");
		l1.forEach(st->System.out.println(st));
		s.close();
		
		
		//update price using pname;
		String hql2="update Product set price=price+100 where pname=:name";
		s=sf.openSession();
		Transaction tx2=s.beginTransaction();
		MutationQuery q2 = s.createMutationQuery(hql2);
		q2.setParameter("name", "laptop");
		int rows=q2.executeUpdate();
		tx2.commit();
		System.out.println(rows);
		s.close();
		
		
		String hql3="delete from Product where id=:id ";
		s=sf.openSession();
		Transaction tx3=s.beginTransaction();
		MutationQuery q3 = s.createMutationQuery(hql3);
		q3.setParameter("id", 1);
		int row=q3.executeUpdate();
		System.out.println(row);
		tx3.commit();
		s.close();
		
	}

}
