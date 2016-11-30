package cs320.midterm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/midterm/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AddUser() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/midterm/AddUser.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	 String username = request.getParameter("username");
	 String addEmtpy = "";
	 if(username != "" && username != null)
	 {
		 ArrayList<UserModel> users = new ArrayList<UserModel>();
		 users = (ArrayList<UserModel>) getServletContext().getAttribute("users");
		 users.add(new UserModel(username));
		 getServletContext().setAttribute("users", users);
		 response.sendRedirect("DisplayRebate.jsp");
	 }
	 else
	 {
		 addEmtpy = "Enter Username";
		 request.getSession().setAttribute("addEmtpy", addEmtpy);
		 response.sendRedirect("AddUser.jsp");
	 }
	}

}
