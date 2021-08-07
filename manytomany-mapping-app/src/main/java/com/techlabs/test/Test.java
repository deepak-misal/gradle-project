package com.techlabs.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.techlabs.model.Actor;
import com.techlabs.model.Movie;

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
	    
	    Actor a1=new Actor();
	    a1.setActor_id(1);
	    a1.setActor_name("actor1");
	    Actor a2=new Actor(2,"actor2");
	    
	    Set<Actor> actors=new HashSet<Actor>();
	    actors.add(a1);
	    actors.add(a2);
	    
	    Movie m1=new Movie();
	    m1.setMovie_id(11);
	    m1.setMovie_name("movie1");
	    Movie m2=new Movie(12,"movie2");
	    
	    Set<Movie> movies=new HashSet<Movie>();
	    movies.add(m1);
	    movies.add(m2);
	    
	    
	    a1.setMovies(movies);
	    a2.setMovies(movies);
	    
	    m1.setActors(actors);
	    m2.setActors(actors);
	    
	    session.save(a1);
	    session.save(a2);
	    session.save(m1);
	    session.save(m2);
	    
	    txn.commit();
	    session.close();

	}

}
