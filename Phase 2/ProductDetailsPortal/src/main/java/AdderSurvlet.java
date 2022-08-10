import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.Product;

@WebServlet("/AdderSurvlet")
public class AdderSurvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Long id= Long.parseLong(request.getParameter("ID"));
		String name= request.getParameter("pname");
		Float price = Float.parseFloat(request.getParameter("price"));
		Product p = new Product(id,name,price);
		HttpSession session = request.getSession();
		session.setAttribute("id", p.getId());
		session.setAttribute("name", p.getName());
		session.setAttribute("price", p.getPrice());
		
		PrintWriter out = response.getWriter();
		out.println("<a href='display.jsp'>view details</a>");

	}

}
