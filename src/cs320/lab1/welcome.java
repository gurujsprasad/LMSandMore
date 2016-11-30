package cs320.lab1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/lab1/welcome")
public class welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		String username = null;
		username = (String) request.getSession().getAttribute("username");
		out.println("<html><title>Welcome Page</title><body>");
		out.println("<h2> Welcome User - " + username+" </h2><br/>");
		out.println("<a href = 'logout'> logout </a>");
		out.println("</body></html>");
		
	}

}
