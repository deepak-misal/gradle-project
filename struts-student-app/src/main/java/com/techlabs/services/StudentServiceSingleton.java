package com.techlabs.services;

public class StudentServiceSingleton
{
	private static StudentServices studentService = null;
	
	public static StudentServices getService()
	{
		if(studentService == null)
		{
			studentService = new StudentServices();
			return studentService;
		}
		return studentService;
	}
}
