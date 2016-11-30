package cs320.lab1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/lab1/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String invalidLogin = "";
	 
   
    public login() {
        super();
      }

	
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
		ArrayList<UserDetails> userdetails = new ArrayList<UserDetails>();
		userdetails.add(new UserDetails("admin", "admin" , "admin@localhost.com"));
		config.getServletContext().setAttribute("userdetails", userdetails);
	
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//invalidLogin = "";
		PrintWriter out = response.getWriter();
		out.println("<html><title>Login</title><body>");
		out.println("<h2> Login </h2>");
		out.println("<form action = '' method = 'post'>");
		if (invalidLogin != "")
		{
			out.println("<p>"+invalidLogin+"</p>");
		}
		out.println("<table>");
		out.println("<tr><td>Email ID : </td><td><input type = 'text' name = 'emailID' id = 'emailID'/></td></tr>");
		out.println("<tr><td>Password : </td><td><input type = 'password' name = 'pwd' id = 'pwd'/></td></tr>");
		out.println("<tr><td><input type = 'submit' name = 'Login' value = 'Login'/></td>");
		out.println("<td><input type = 'reset' name = 'clear' value = 'Clear'/></td></tr></table>");
		out.println("</form>");
		out.println("<br/><a href = 'registration'> Registration </a>");
		out.println("</body></html>");
		
		
	}

	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<UserDetails> userdetails = new ArrayList<UserDetails>();
		userdetails = (ArrayList<UserDetails>) getServletContext().getAttribute("userdetails");
		invalidLogin="";
		String emailID = request.getParameter("emailID").trim();
		String password = request.getParameter("pwd").trim();
		String username = null;
		int flag = 0;
		for(UserDetails userdetail : userdetails)
		{
			if(userdetail.getEmailID().equals(emailID) && userdetail.getPassword().equals(password))
			{
				request.getSession().setAttribute("emailID", emailID);
				username = userdetail.getUsername();
				request.getSession().setAttribute("username",username );
				invalidLogin = "";
				flag=1;
				
			}
		}
			if(flag == 1)
			{
				response.sendRedirect("welcome");
			}
			else
			{
				invalidLogin = "Email id or password is not correct, please try again";
				response.reset();
				doGet(request, response);
				
			}
		
	}

}
