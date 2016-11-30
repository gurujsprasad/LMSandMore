package cs320.finals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/finals/Final")
public class Final extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DBFunctions db = new DBFunctions();
   
    public Final() {
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
		 
		 Connection con = db.dbConnection();
		 ResultSet results;
		 Statement stmt = null;
		 ArrayList<MeetingsBean> meetings = new ArrayList<MeetingsBean>();
		 ArrayList<TimeSlotsBean> timeSlots = new ArrayList<TimeSlotsBean>();
		 ArrayList<DaysBean> days = new ArrayList<DaysBean>();
		 
		 String queryMeetings = "select * from meetings";
		 String queryTimeSlots = "select * from timeslots";
		 String queryDays =  "select * from days";
		try {
			stmt = (Statement) con.createStatement();
			results = stmt.executeQuery(queryMeetings);
			while(results.next())
			{
				meetings.add(new MeetingsBean(results.getInt("meeting_id"), results.getInt("time_slot_id"), results.getInt("day_id"), results.getString("notes")));
			}
			results.close();
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
		getServletContext().setAttribute("meetings", meetings);
		getServletContext().setAttribute("timeSlots", timeSlots);
		getServletContext().setAttribute("days", days);
		request.getRequestDispatcher("/WEB-INF/jsp/finals/Final.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
