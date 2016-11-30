package cs320.lab1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/lab1/registration")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String validation = null;     
  
    public registration() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html><title>Registration</title><body>");
		out.println("<h2> New User </h2>");
		if (validation != null)
		{
			out.println("<p>"+ validation +"</p>");
		}
		out.println("<form action = '' method = 'post'>");
		out.println("<table>");
		out.println("<tr><td>Username : </td><td><input type = 'text' name = 'username' id = 'username'/></td></tr>");
		out.println("<tr><td>Password : </td><td><input type = 'password' name = 'pwd' id = 'pwd'/></td></tr>");
		out.println("<tr><td>Confirm Password : </td><td><input type = 'password' name = 'cpwd' id = 'cpwd'/></td></tr>");
		out.println("<tr><td>Email ID: </td><td><input type = 'text' name = 'emailID' id = 'emailID'/></td></tr>");
		out.println("<tr><td><input type = 'submit' name = 'Register' value = 'Register'/> </td></td></tr>");
		out.println("<tr><td><input type = 'reset' name = 'clear' value = 'Clear'/></td></tr></table>");
		out.println("</form>");
		out.println("</body></html>");
	}

	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username").trim() ;
		String password = request.getParameter("pwd").trim();
		String confirmPassword = request.getParameter("cpwd").trim();
		String emailID = request.getParameter("emailID").trim();
		ArrayList<UserDetails> userdetails = new ArrayList<UserDetails>();
		
		userdetails = (ArrayList<UserDetails>) getServletContext().getAttribute("userdetails");
		
		if (username != "" && password != "" && confirmPassword != "" && emailID != "")
		{
			if (password.equals(confirmPassword))
			{
				userdetails.add(new UserDetails(username, password, emailID));
				getServletContext().setAttribute("userdetails", userdetails);
				validation = null;
				
				response.sendRedirect("login");
			}
			else
			{
				validation = "Password entered does'nt match with confirm password field";
				doGet(request, response);
			
			}
			
		}
		else
		{
			
			validation = "Enter all the fields";
			doGet(request, response);
		}
	}

}
