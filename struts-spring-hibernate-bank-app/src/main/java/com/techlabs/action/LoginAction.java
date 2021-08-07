package com.techlabs.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.model.LoginBean;
import com.techlabs.repository.LoginRepository;

public class LoginAction implements Action{
	@Autowired
	private LoginRepository repo;
	private LoginBean loginBean;
	
	
	public String login() {
		String username=loginBean.getUsername();
		String password=loginBean.getPassword();
		
		(this.loginBean=new LoginBean()).setUsername(username);
		this.loginBean.setPassword(password);
			
		String userValidate=repo.authenticateUser(this.loginBean);
		if(userValidate.equals("Validuser")) {
			 HttpSession session=ServletActionContext.getRequest().getSession();
			 session.setAttribute("Admin", username);
			 ServletActionContext.getRequest().setAttribute("username", username);
			 return this.SUCCESS;
		}
		else {
				System.out.println(userValidate);
				ServletActionContext.getRequest().setAttribute("errMessage", userValidate);
				return this.ERROR;
		}
		
	}
	

	@Override
	public String execute() throws Exception {
		return null;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}


	public LoginRepository getRepo() {
		return repo;
	}


	public void setRepo(LoginRepository repo) {
		this.repo = repo;
	}
}
