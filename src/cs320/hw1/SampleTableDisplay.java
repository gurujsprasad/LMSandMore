package cs320.hw1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleTableDisplay
 */
@WebServlet("/SampleTableDisplay")
public class SampleTableDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SampleTableDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 try
	        {
	            Class.forName( "com.mysql.jdbc.Driver" );
	        }
	        catch( ClassNotFoundException e )
	        {
	            throw new ServletException( e );
	        }
		 
		 Connection con = null;
		 Statement stmt = null;
		 
		 String url= "jdbc:mysql://localhost/cs320stu110";
		 String username = "root";
		 String passwrod = "abcd";
		 try {
			con = DriverManager.getConnection(url, username, passwrod);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 String query = "select * from sampletable";
		 try {
			 stmt = (Statement) con.createStatement();
			ResultSet results = stmt.executeQuery(query);
			while (results.next())
			{
				response.getWriter().println("user name is :"+results.getString("name"));
			}
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
