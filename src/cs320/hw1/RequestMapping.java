package cs320.hw1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.hw1.models.*;

@WebServlet("/hw1/RequestMapping")
public class RequestMapping extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MysqlDB db = new MysqlDB();   
  
    public RequestMapping() {
        super();
      
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
		int apartmentID = 0;
		int userID = 0;
		String status = "";
		
		String username = (String) request.getSession().getAttribute("username");	
		if (username != null && username != "")
		{
			Connection con = db.dbConnection();
			CallableStatement cstmt = null;
			status = ApointmentStatus.REQUESTED.toString(); // REQUESTED || ACCEPTED || DENIED => AppointmentStatus ENUM
			if(request.getParameter("apartmentID") != "")
			{
				apartmentID = Integer.parseInt(request.getParameter("apartmentID"));
			}
			if(request.getParameter("userID") != "")
			{
				userID = Integer.parseInt(request.getParameter("userID"));
			}
			String fetchApartmentsQuery = "{call RequestMapping ('"+apartmentID+"','"+userID+"','"+status+"')}";
			
			try {
				cstmt = con.prepareCall (fetchApartmentsQuery);
				cstmt.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
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
			response.sendRedirect("LookUpApartment");
		}
		else
		{	
			request.getSession().invalidate();
			response.reset();
			response.sendRedirect("Login.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
