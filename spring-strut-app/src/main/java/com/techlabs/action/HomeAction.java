package com.techlabs.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.service.StudentService;

public class HomeAction implements Action{
	
	@Autowired
	private StudentService service;
	private int count;
	public int getCount() {
		return count;
	}
	
	@Override
	public String execute() throws Exception {
		count=service.get().size();
		System.out.println(count);
		return this.SUCCESS;
	}

}
