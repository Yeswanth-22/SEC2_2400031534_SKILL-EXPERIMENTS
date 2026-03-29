package com.klu.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.klu.entity.Product;

import jakarta.persistence.Tuple;

public class ProductApp {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Product p1=new Product("laptop",10000.0,"gaming laptop",2);
		Product p2=new Product("mobile",5000.0,"android",3);
		Product p3=new Product("car",700000.0,"sports-car",5);
		Product p4=new Product("touchpad",1000.0,"mac",9);
		Product p5=new Product("laptop",100000.0,"gaming laptop",5);
		s.persist(p1); s.persist(p2); s.persist(p3); s.persist(p4); s.persist(p5);
		tx.commit();
		s.close();
		String hql="from Product order by price ASC";
		s=sf.openSession();
		//.Transaction tx1=s.beginTransaction();
		Query<Product> query = s.createQuery(hql, Product.class);
		List<Product> l=query.getResultList();
		l.forEach(asc->System.out.println(asc));
		s.close();
		
		String hql1="from Product order by price DESC";
		s=sf.openSession();
		Query<Product> query2 = s.createQuery(hql1, Product.class);
		List<Product> l1 = query2.getResultList();
		l1.forEach(desc->System.out.println(desc));
		s.close();
		
		String hql3="from Product order by quantity DESC";
		s=sf.openSession();
		Query<Product> query3 = s.createQuery(hql3, Product.class);
		List<Product> l2 = query3.getResultList();
		l2.forEach(sort->System.out.println(sort));
		s.close();
		
		String hql4="from Product";
		s=sf.openSession();
		Query<Product> query4 = s.createQuery(hql4, Product.class);
		query4.setFirstResult(0);
		query4.setMaxResults(3);
		List<Product> l3 = query4.getResultList();
		System.out.println("first 3 products");
		l3.forEach(f1->System.out.println(f1));
		
		query4.setFirstResult(3);
		query4.setMaxResults(3);
		List<Product> l4 = query4.getResultList();
		System.out.println("next 3 products");
		l4.forEach(f2->System.out.println(f2));
		s.close();
		
		String hql5="select description,count(*) from Product group by description";
		s=sf.openSession();
		Query<Tuple> query5 = s.createQuery(hql5, Tuple.class);
		List<Tuple> l5 = query5.getResultList();
		l5.forEach(d->System.out.println(d));
		s.close();
		
		String hql6="FROM Product WHERE price BETWEEN :minPrice AND :maxPrice";
		s=sf.openSession();
		Query<Product> query6 = s.createQuery(hql6, Product.class);
		query6.setParameter("minPrice",1000);
		query6.setParameter("maxPrice", 100000);
		List<Product> l6 = query6.getResultList();
		l6.forEach(m->System.out.println(m));
		s.close();
		
		String hql7="FROM Product p WHERE p.pname LIKE 'a%'";
		s=sf.openSession();
		Query<Product> query7 = s.createQuery(hql7, Product.class);
		List<Product> l7 = query7.getResultList();
		l7.forEach(a->System.out.println(a));
		s.close();
		
		String hql8="FROM Product p WHERE p.pname LIKE '%a'";
		s=sf.openSession();
		Query<Product> query8 = s.createQuery(hql8,Product.class);
		List<Product> l8 = query8.getResultList();
		l8.forEach(e->System.out.println(e));
		s.close();
	}
}
