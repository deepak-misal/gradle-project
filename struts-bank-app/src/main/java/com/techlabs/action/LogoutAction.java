package com.techlabs.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class LogoutAction implements Action{
	
	public String logout() {
		HttpSession session=ServletActionContext.getRequest().getSession(false);
		if(session!=null) {
			session.invalidate();
			System.out.println("Logged Out");
		}
		return this.SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
