package com.techlabs.actions;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.opensymphony.xwork2.Action;

public class BrowseAction implements Action{
	private String msg = "Hello , Good Afternoon";
	private LocalDateTime time=java.time.LocalDateTime.now();
	
	public LocalDateTime getTime() {
		return time;
	}
    
    public String getMsg() {
        return msg;
    }
	@Override
	public String execute() throws Exception {
		return this.SUCCESS;
	}

}
