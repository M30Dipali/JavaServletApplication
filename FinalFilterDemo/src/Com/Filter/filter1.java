package Com.Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/serv")
public class filter1 implements Filter {
public void init(FilterConfig fConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		if(name.equals("")) {
			pw.print("name is required");
		}
		else if(pass.equals("")) {
			pw.print("password is required");
		}
		else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		
	}

	
}
