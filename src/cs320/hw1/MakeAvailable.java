package cs320.hw1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.hw1.models.*;
import cs320.hw1.*;


@WebServlet("/hw1/MakeAvailable")
public class MakeAvailable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MysqlDB db = new MysqlDB();    
  
    public MakeAvailable() {
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
		String username = (String) request.getSession().getAttribute("username");	
		if (username != null && username != "")
		{
			int apartmentID = Integer.parseInt(request.getParameter("aptID"));
			Connection con = db.dbConnection();
			CallableStatement cstmt = null;
			
			String makeAvailableQuery = "{call MakeAvailable ('"+apartmentID+"')}";
			try {
				cstmt = con.prepareCall (makeAvailableQuery);
				ResultSet result = cstmt.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
			 if(con != null)
			 {
				 try {
					cstmt.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			 }
			}
			response.sendRedirect("ViewApartment");
		}
		else
		{	
			request.getSession().invalidate();
			response.reset();
			response.sendRedirect("Login");
		}
	}
	
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
