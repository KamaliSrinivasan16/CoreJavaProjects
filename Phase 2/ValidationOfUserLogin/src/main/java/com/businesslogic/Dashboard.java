package com.businesslogic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public Dashboard() 
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
		HttpSession session=request.getSession();
		String uname=(String)session.getAttribute("username");
		PrintWriter out=response.getWriter();
		out.println("Welcome User, "+uname);
		out.println("<a href='Logout'>Logout from Dashboard</a>");
	}

}
