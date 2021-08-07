package com.techlabs.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.techlabs.model.Customer;
import com.techlabs.model.LineItem;
import com.techlabs.model.Orders;
import com.techlabs.model.Product;

public class Test {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

	    System.out.println(configuration);
	    StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	        .applySettings(configuration.getProperties()).build();

	    SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

	    Session session = factory.openSession();

	    System.out.println(session.getClass());
	    Transaction txn = session.beginTransaction();
	    
	    Customer customer=new Customer();
	    customer.setCid(10);
	    customer.setName("abc");
	    
	    Orders ord1=new Orders(1,"02/08/2021");
	    Orders ord2=new Orders(2,"03/08/2021");
	    Orders ord3=new Orders();
	    ord3.setOid(3);
	    ord3.setOdate("04/08/2021");
	    ord1.setCustomer(customer);
	    ord2.setCustomer(customer);
	    ord3.setCustomer(customer);
	    
	    Set<Orders> orders=new HashSet<Orders>();
	    orders.add(ord1);
	    orders.add(ord2);
	    orders.add(ord3);
	    customer.setOrders(orders);
	    session.save(customer);
	    
	    LineItem l1=new LineItem(11,5);
	    LineItem l2=new LineItem(12,4);
	    LineItem l3=new LineItem();
	    l3.setLid(13);
	    l3.setQuantity(3);
	    l1.setOrder(ord3);
	    l2.setOrder(ord3);
	    l3.setOrder(ord3);
	    
	    Set<LineItem> items=new HashSet<LineItem>();
	    items.add(l1);
	    items.add(l2);
	    items.add(l3);
	  
	    
	    Product p1=new Product(100,"product1",200);
	    Product p2=new Product(101,"product2",250);
	    p1.setItem(l3);
	    p2.setItem(l3);
	    Set<Product> products=new HashSet<Product>();
	    products.add(p1);
	    products.add(p2);
	    l3.setProducts(products);
	    session.save(ord3);
	    session.save(l3);
	    txn.commit();
	    session.close();
	    
	    

	}

}
