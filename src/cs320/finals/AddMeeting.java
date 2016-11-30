package cs320.finals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/finals/AddMeeting")
public class AddMeeting extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBFunctions db = new DBFunctions();
	
    public AddMeeting() {
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
	 
	 Connection con = db.dbConnection();
	 ResultSet results;
	 Statement stmt = null;
	
	 ArrayList<TimeSlotsBean> timeSlots = new ArrayList<TimeSlotsBean>();
	 ArrayList<DaysBean> days = new ArrayList<DaysBean>();
	 
	
	 String queryTimeSlots = "select * from timeslots";
	 String queryDays =  "select * from days";
	try {
		stmt = (Statement) con.createStatement();
		results = stmt.executeQuery(queryTimeSlots);
		while(results.next())
		{
			timeSlots.add(new TimeSlotsBean(results.getInt("time_slot_id"),results.getString("time_slot")));
		}
		results.close();
		
		results = stmt.executeQuery(queryDays);
		while(results.next())
		{
			days.add(new DaysBean(results.getInt("day_id"),results.getString("days")));
		}
		results.close();
		
	} catch (SQLException e) {
		
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
	
	getServletContext().setAttribute("timeSlots", timeSlots);
	getServletContext().setAttribute("days", days);
		
		request.getRequestDispatcher("/WEB-INF/jsp/finals/AddMeeting.jsp").forward(request, response);
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
	 
	 Connection con = db.dbConnection();
	 ResultSet results;
	 PreparedStatement stmt = null;
	 
	 int dayID = Integer.parseInt(request.getParameter("day"));
	 int timeSlotID =Integer.parseInt( request.getParameter("timeSlot"));
	 String notes = request.getParameter("notes");
	 
	 
	 String queryInsertMeeting = "INSERT INTO `cs320stu110`.`meetings` (`time_slot_id`, `day_id`, `notes`) VALUES (?,?,?);";
	try {
		
		stmt = con.prepareStatement(queryInsertMeeting);
		stmt.setInt(1, timeSlotID);
		stmt.setInt(2, dayID);
		stmt.setString(3, notes);
		stmt.executeUpdate();
	} catch (SQLException e) {
		
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

}
