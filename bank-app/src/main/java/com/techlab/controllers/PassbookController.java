package com.techlab.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techlab.model.Transaction;
import com.techlab.services.BankService;
import com.techlab.services.IBankService;


public class PassbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public PassbookController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name=(String) session.getAttribute("Admin");
		IBankService service=new BankService();
		List<Transaction> transactions=service.getListByName(name);
		request.setAttribute("transactionList", transactions);
		RequestDispatcher view = request.getRequestDispatcher("passbook.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
