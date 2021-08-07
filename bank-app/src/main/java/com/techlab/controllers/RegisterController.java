package com.techlab.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlab.model.AccountHolder;
import com.techlab.model.Transaction;
import com.techlab.services.BankService;
import com.techlab.services.IBankService;

public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("register.jsp");
		view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		int balance=Integer.parseInt(request.getParameter("obalance"));
		String pass=request.getParameter("pass");
		String repass=request.getParameter("repass");
		String type="D";
		if(pass.equals(repass)) {
			IBankService service=new BankService();
			service.addAccount(new AccountHolder(name,balance,pass));
			service.addTransactcion(new Transaction(name,balance,type));
			response.sendRedirect("http://localhost:8085/bank-app/home");
		}
		else {
			request.setAttribute("errMessage","Password is not matching");
			 
            request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		
	}

}
