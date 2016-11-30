package cs320.finals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/finals/EditMeeting")
public class EditMeeting extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBFunctions db = new DBFunctions();   
    
    public EditMeeting() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int meetingId = Integer.parseInt(request.getParameter("meetingID"));
		String query = "select m.meeting_id, d.days, t.time_slot, m.notes from meetings m, timeslots t, days d where m.meeting_id = ? and d.day_id = m.day_id and t.time_slot_id = m.time_slot_id";
		ArrayList<FetchMeetingForEditBean> meeting = new ArrayList<FetchMeetingForEditBean>();
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
		
		try {
			
			stmt = con.prepareStatement(query);
			stmt.setInt(1, meetingId);
			results = stmt.executeQuery();
			while (results.next())
			{
				meeting.add(new FetchMeetingForEditBean(results.getInt("meeting_id"), results.getString("days"), results.getString("time_slot"), results.getString("notes")));
			}
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
		getServletContext().setAttribute("meeting", meeting);
		request.getRequestDispatcher("/WEB-INF/jsp/finals/EditMeeting.jsp").forward(request, response);
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		int meetingId = Integer.parseInt(request.getParameter("meetingID"));
		String notes = request.getParameter("notes");
		String button = request.getParameter("button");
		String query = "";
		int flag = 0;
		if(button.equals("SAVE"))
		{
			flag = 1;
			query = "update meetings set notes = ? where meeting_id = ?";
		}
		if (button.equals("DELETE"))
		{
			flag = 2;
			query = "delete from meetings where meeting_id = ?";
		}
		
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
		
		try {
			
			stmt = con.prepareStatement(query);
			if (flag == 1)
			{
				stmt.setString(1, notes);
				stmt.setInt(2, meetingId);
			}
			if (flag == 2)
			{
				stmt.setInt(1, meetingId);
			}
			
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
