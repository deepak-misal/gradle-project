package com.techlab.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techlab.model.LoginBean;
import com.techlab.repository.LoginRepository;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("login.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		LoginBean login=new LoginBean(username,password);
		LoginRepository loginrepo=new LoginRepository();
	
		String userValidate=loginrepo.authenticateUser(login);
		if(userValidate.equals("Validuser")) {
			System.out.println("Valid");
			HttpSession session = request.getSession(); 
            session.setAttribute("Admin", username);
            request.setAttribute("username", username);
            System.out.println(username);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
		}
		else
        {
            System.out.println("Error message = "+userValidate);
            request.setAttribute("errMessage", userValidate);
 
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
	}

}
