package com.techlabs.actions;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.techlabs.model.Student;
import com.techlabs.services.StudentServiceSingleton;
import com.techlabs.services.StudentServices;

public class AddAction implements Action{
	private Student student;
	StudentServiceSingleton service=new StudentServiceSingleton();
	StudentServices ser=service.getService();
	List<Student> students;

	@Override
	public String execute() throws Exception {
		return null;
	}
	public String add() {
		
		
		if(student.getRollNo()!=0 && student.getName()!=null && student.getCgpa()!=0) {
			ser.addStudent(student);
			return this.SUCCESS;
		}
		else {
			return this.ERROR;
		}
	}
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
