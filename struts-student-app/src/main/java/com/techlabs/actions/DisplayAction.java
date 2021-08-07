package com.techlabs.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.techlabs.model.Student;
import com.techlabs.services.StudentServiceSingleton;
import com.techlabs.services.StudentServices;

public class DisplayAction implements Action{
	List<Student> students;
	StudentServiceSingleton service=new StudentServiceSingleton();
	StudentServices ser=service.getService();
	
	@Override
	public String execute() throws Exception {
		students=ser.getList();
		return this.SUCCESS;
	}
	public List<Student> getStudents(){
		return ser.getList();
	}
	public void setStudents(List<Student> students) {
		this.students=students;
	}
}
