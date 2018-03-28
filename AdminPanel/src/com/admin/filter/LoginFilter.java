package com.admin.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/LoginServlet")
public class LoginFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out=response.getWriter();  
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		if(email.equals("admin@gmail.com") && pass.equals("admin123")){
		   chain.doFilter(request, response);
	    }else {
	    	out.print("<p>Sorry, name or password is incorrect</p>");
	    }
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
