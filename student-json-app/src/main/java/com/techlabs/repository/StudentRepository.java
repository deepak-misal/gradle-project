package com.techlabs.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.techlabs.model.Student;

@Repository
public class StudentRepository {

	private List<Student> studentList;
	
	
	public StudentRepository() {
		System.out.println("New Student Repository Created");
		studentList = new ArrayList<Student>();
		studentList.add(new Student("Student1", 34, 4.5));
		studentList.add(new Student("Student2", 35, 4.6));
		studentList.add(new Student("Student3", 36, 4.7));
	}

	public List<Student> getStudents() {
		return this.studentList;
	}

}
