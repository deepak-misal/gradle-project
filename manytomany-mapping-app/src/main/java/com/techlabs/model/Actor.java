package com.techlabs.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Actor {
	@Id
	private int actor_id;
	private String actor_name;
	@ManyToMany(mappedBy="actors", cascade = CascadeType.ALL)
	private Set<Movie> movies;
	public Actor(int actor_id,String actor_name) {
		this.actor_id=actor_id;
		this.actor_name=actor_name;
	}
	public Actor() {
		
	}
	public int getActor_id() {
		return actor_id;
	}
	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}
	public String getActor_name() {
		return actor_name;
	}
	public void setActor_name(String actor_name) {
		this.actor_name = actor_name;
	}
	public Set<Movie> getMovies(){
		return movies;
	}
	public void setMovies(Set<Movie> movies) {
		this.movies=movies;
	}
}
