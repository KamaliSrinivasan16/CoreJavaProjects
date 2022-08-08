package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.EProduct;

@WebServlet("/ListProducts")
public class ListProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = request.getParameter("name");
		long price = Integer.parseInt(request.getParameter("price"));
		EProduct e1 = new EProduct();
		e1.setName(name);
		e1.setPrice(price);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		long i = (long) session.save(e1);
		session.getTransaction().commit();

		session.close();

		PrintWriter out = response.getWriter();
		if (i > 0)
			out.println("Record inserted");
		else
			out.println("Record not inserted");
		
		
	}

}
