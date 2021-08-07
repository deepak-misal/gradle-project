package com.techlabs.action;

import com.opensymphony.xwork2.Action;

public class HomeAction implements Action{

	@Override
	public String execute() throws Exception {
		return this.SUCCESS;
	}

}
