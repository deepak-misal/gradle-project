package com.techlabs.model;

public class Student {
	private int rollNo;
	private String name;
	private double cgpa;
	public Student(int rollNo,String name,double cgpa) {
		this.rollNo=rollNo;
		this.name=name;
		this.cgpa=cgpa;
	}
	public Student() {
		
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
}
