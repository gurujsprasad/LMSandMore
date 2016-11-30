package cs320.finals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/finals/AddTimeSlot")
public class AddTimeSlot extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBFunctions db = new DBFunctions(); 
    
    public AddTimeSlot() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/finals/AddTimeSlot.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 try
	        {
	            Class.forName( "com.mysql.jdbc.Driver" );
	        }
	        catch( ClassNotFoundException e )
	        {
	            throw new ServletException( e );
	        }
		
		String timeSlot = request.getParameter("timeSlot");
		
		if (timeSlot != "" && timeSlot != null)
		{
			PreparedStatement stmt = null;
			Connection con = db.dbConnection();
			String queryMeetings = "INSERT INTO `cs320stu110`.`timeslots` (`time_slot`) VALUES (?)";
			try {
				stmt = con.prepareStatement(queryMeetings);
				stmt.setString(1, timeSlot);
				stmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				if(con != null || stmt != null)
				{
					try {
						stmt.close();
						con.close();
					} catch (SQLException e) {
					
						e.printStackTrace();
					}
					
				}
			}
			response.sendRedirect("Final");
		}
		else
		{
			String error = "Enter Time Slot Details";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/WEB-INF/jsp/finals/AddTimeSlot.jsp").forward(request, response);
			
		}
		
		
	}

}
