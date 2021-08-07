package com.techlabs.test;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.techlabs.model.Talent;

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
    Talent t1 = new Talent(1, "deepak", 9.16f);
    Talent t2=new Talent(2,"abc",9f);
    Talent t3=new Talent(3,"pqr",8f);
    Talent t4=new Talent(4,"xyz",7f);
    Talent t5=new Talent(5,"lmno",9f);
    
    System.out.println("Insert:");
//    session.save(t2);
//    session.save(t3);
//    session.save(t4);
    session.save(t5);
    
    System.out.println("Update:");
//    t1.setName("dee");
//    t1.setCgpa(5f);
//    session.saveOrUpdate(t1);
    
//    System.out.println("Delete:");
//    session.delete(t4);
//    txn.commit();

    session.close();

  }
}