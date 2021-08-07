package com.techlabs.actions;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorld extends ActionSupport{
	private String name;

	   public String execute() throws Exception {
	      if ("Deepak".equals(name)) {
	         return SUCCESS;
	      } else {
	         return ERROR;  
	      }
	   }
	   
	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }
}
