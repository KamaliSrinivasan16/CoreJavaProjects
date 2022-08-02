package com.businesslogic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request,response);
		response.setContentType("text/html");
		String uname = request.getParameter("uName");
		String pword = request.getParameter("pwd");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd;
		
        if(uname.equals("java@abc.com") && pword.equals("abc123"))
        {
        	HttpSession session=request.getSession(true);
        	session.setAttribute("username", uname);
			rd=request.getRequestDispatcher("Dashboard");
			rd.forward(request, response);
		}
		else {
			out.println("Invalid Username or Password");
			rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		
	}

}
