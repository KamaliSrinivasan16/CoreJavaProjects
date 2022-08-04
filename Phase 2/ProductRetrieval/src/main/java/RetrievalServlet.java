import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.DBConnection;

@WebServlet("/RetrievalServlet")
public class RetrievalServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public RetrievalServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 try {
             PrintWriter out = response.getWriter();
             out.println("<html><body>");
  
            int id = Integer.parseInt(request.getParameter("Product_ID"));  
            
            Connection con=DBConnection.getMyConnection();
            String str="select * from eproduct";
            Statement  ps=con.createStatement();

			ResultSet ans =ps.executeQuery(str);
	

			out.println("<table border=2>");
			out.println("<tr><th>Rollno</th><th>Name</th><th>Marks</th></tr>");

			while(ans.next()) {
				if(ans.getInt("ID")==id)
				{
					out.println("<tr>");
					out.print("<td>"+ans.getInt("ID")+"</td>");
					out.print("<td>"+ans.getString("name")+"</td>");
					out.print("<td>"+ans.getInt("price")+"</td>");
					out.println("</tr>");
				}
				
			}
			out.println("</table>");
			con.close();

            out.println("</body></html>");
 
    } catch (SQLException e) {
            e.printStackTrace();
    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
