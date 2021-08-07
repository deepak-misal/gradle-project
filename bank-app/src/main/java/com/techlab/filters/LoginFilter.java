package com.techlab.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns= {"/transaction","/passbook",})
public class LoginFilter implements Filter {

    public LoginFilter() {

    }

	public void destroy() {

	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		if(session.getAttribute("Admin")==null) {
			res.sendRedirect("http://localhost:8085/bank-app/login.jsp");
		}
		else {
			chain.doFilter(req, res);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
