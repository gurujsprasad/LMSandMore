package cs320.lab5;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


@WebServlet(value= "/lab5/ViewLibraryDB",loadOnStartup = 1)
public class ViewLibraryDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	 public void init( ServletConfig config ) throws ServletException
	    {
	        super.init( config );

	        try
	        {
	            Class.forName( "com.mysql.jdbc.Driver" );
	        }
	        catch( ClassNotFoundException e )
	        {
	            throw new ServletException( e );
	        }
	    }
   
    public ViewLibraryDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String url = "jdbc:mysql://cs3.calstatela.edu/cs320stu110";
		 String username = "root"; //cs320stu110
	     String password = "abcd"; // !nJM*Lgn
         ArrayList<Books> books = new ArrayList<Books>();
         Connection c = null;
         try {
			 c = (Connection) DriverManager
			         .getConnection( url, username, password );
			
			 Statement stmt = (Statement) c.createStatement();
	         ResultSet rs = (ResultSet) stmt.executeQuery( "select * from books" );
	         
	         while(rs.next())
	         {
	        	 books.add(new Books (rs.getInt("id"),rs.getString("title"),rs.getString("author"),rs.getInt("copies")));
	         }
	         
	         request.getSession().setAttribute("books", books);
	         request.getRequestDispatcher("/WEB-INF/jsp/lab5/ViewLibrary.jsp").forward(request, response);
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
