package cs320.lab5;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import cs320.lab3.BooksModel;


@WebServlet("/lab5/AddToLibraryDB")
public class AddToLibraryDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddToLibraryDB() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/lab5/AddToLibrary.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String title = request.getParameter("title").trim();
		String Author = request.getParameter("Author").trim();
		int copies = 0;
		if(request.getParameter("copies").trim() != "")
		{
			copies = Integer.parseInt(request.getParameter("copies").trim());
		}
		String url = "jdbc:mysql://localhost/cs320stu110";
		String username = "root"; //cs320stu110
	    String password = "abcd"; // !nJM*Lgn
        String  query = "";
        Connection c = null;
        if(title != ""  && Author != "" && copies != 0)
 		{
        try {
        	
        	
        	c = (Connection) DriverManager
			         .getConnection( url, username, password );
			
			 	query = "Insert into books(title,author,copies)values ('" + title+"','" + Author+"','" + copies+"')";
			 	Statement stmt = (Statement) c.createStatement();
		        stmt.executeUpdate( query );
	 			response.sendRedirect("ViewLibraryDB");
	 		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
       finally
       {
       	try {
       		if (c != null)
    		{
    			c.close();
    		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       }
 	}
    else
	{
    	request.getSession().setAttribute("formError", "Enter all the fields");
    	request.getRequestDispatcher("/WEB-INF/jsp/lab5/AddToLibrary.jsp").forward(request, response);
	}
		
	}

}
