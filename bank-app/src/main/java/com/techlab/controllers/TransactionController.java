package com.techlab.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techlab.model.Transaction;
import com.techlab.services.BankService;
import com.techlab.services.IBankService;

public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TransactionController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("transaction.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int amount=Integer.parseInt(request.getParameter("amount"));
		String type=request.getParameter("transaction");
		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("Admin");
		IBankService service=new BankService();
		if(type.equals("D")) {
			service.addTransactcion(new Transaction(name,amount,type));
			service.updateDeposite(new Transaction(name,amount,type));
		}
		else {
			service.addTransactcion(new Transaction(name,amount,type));
			service.updateWithdraw(new Transaction(name,amount,type));
		}
		response.sendRedirect("home.jsp");
	}

}
