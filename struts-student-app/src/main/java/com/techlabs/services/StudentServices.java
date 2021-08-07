package com.techlabs.services;

import java.util.ArrayList;
import java.util.List;

import com.techlabs.model.Student;

public class StudentServices {
	List<Student> students=new ArrayList<Student>();
	public StudentServices() {
		students.add(new Student(1,"abc",9.5));
		students.add(new Student(2,"pqr",9.5));
		students.add(new Student(3,"xyz",9.5));
		students.add(new Student(4,"lmno",9.5));
	}
	
	public void addStudent(Student student) {
		students.add(student);
		System.out.println("Added to List");
	}
	public List<Student> getList(){
		return students;
	}
}
