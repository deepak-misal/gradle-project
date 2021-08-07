package com.techlabs.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.techlabs.model.Student;

@Repository
public class StudentRepository {
	List<Student> students=new ArrayList<Student>();
	
	public StudentRepository() {
		System.out.println("Repo Created");
		students.add(new Student(1,"abc",9.5));
		students.add(new Student(2,"pqr",9.5));
		students.add(new Student(3,"xyz",9.5));
	}
	public List<Student> getStudents(){
		return students;
	}
}
