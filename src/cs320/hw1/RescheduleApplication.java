package cs320.hw1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.hw1.models.*;

@WebServlet("/hw1/RescheduleApplication")
public class RescheduleApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MysqlDB db = new MysqlDB();  
    
    public RescheduleApplication() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
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
		PrintWriter out = response.getWriter();
		//out.println("<html><title>LMS</title><body>");		
		
		//ArrayList<ApplicationModel> applications = new ArrayList<ApplicationModel>();
		//applications = (ArrayList<ApplicationModel>)getServletContext().getAttribute("applications");
		
		String dateInvalid = "";
		
		int applicationID = 0; // need at DB end
		int apartmentID = 0;
		String rescheduleDate = ""; //need at DB end
		String status = ApointmentStatus.SCHEDULED.toString(); //need at DB end
		if(request.getParameter("applicationID") != "")
		{
			applicationID = Integer.parseInt(request.getParameter("applicationID"));
		}
		if(request.getParameter("apartmentID") != "")
		{
			apartmentID = Integer.parseInt(request.getParameter("apartmentID"));
		}
		rescheduleDate = request.getParameter("rescheduleDate").trim();
		
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		SimpleDateFormat dbDate = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		String dbInsertDate = "";
		Date enteredDate = null;	
		
		try {
			enteredDate = df.parse(rescheduleDate);
		} catch (ParseException e) {
			dateInvalid = "Please enter the date and in format mm/dd/yyyy hh:mm:ss";
			request.getSession().setAttribute("dateInvalid", dateInvalid);
			response.reset();
			response.sendRedirect("ViewAppointment?apartmentID="+apartmentID);
		    return;
		}
		
		Date dateObj =  new Date(rescheduleDate);
		dbInsertDate = dbDate.format(dateObj);
		String rescheduleApplicationQuery = "{call RescheduleApplication ('"+applicationID+"','"+dbInsertDate+"','"+status+"')}";
		Connection con = db.dbConnection();
		CallableStatement cstmt = null;
		try {
			cstmt = con.prepareCall (rescheduleApplicationQuery);
			cstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(cstmt != null || con != null)
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
		response.sendRedirect("ViewAppointment?apartmentID="+apartmentID);
	}

}
