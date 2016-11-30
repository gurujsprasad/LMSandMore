package cs320.hw1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.hw1.models.*;


@WebServlet("/hw1/LookUpApartment")
public class LookUpApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MysqlDB db = new MysqlDB();   
   
    public LookUpApartment() {
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
		int userID = 0;
		String appointmentDate = "";
		SimpleDateFormat displayDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		if (request.getSession().getAttribute("userID") != null)
		{
			userID = (int) request.getSession().getAttribute("userID");
		}
		Connection con = db.dbConnection();
		CallableStatement cstmt = null;
		ArrayList<ApartmentsBean> apartments = new ArrayList<ApartmentsBean>();
		ArrayList<ApplicationsBean> applications = new ArrayList<ApplicationsBean>();
		String fetchApartmentsQuery = "{call GetApartments ()}";
		String fetchApplicationsQuery = "{call GetApplications ('"+userID+"')}";
		try {
			cstmt = con.prepareCall (fetchApartmentsQuery);
			ResultSet apartment = cstmt.executeQuery();
			
			while (apartment.next())
			{
				apartments.add(new ApartmentsBean(apartment.getInt("apartment_id"),apartment.getString("apartment_no"),apartment.getString("apartment_type"),apartment.getString("facility"),apartment.getString("max_people"),apartment.getInt("rent"),apartment.getInt("deposit"),apartment.getString("vacancy")));
			}
			cstmt.close();
			cstmt = con.prepareCall (fetchApplicationsQuery);
			ResultSet application = cstmt.executeQuery();
			while(application.next())
			{
				appointmentDate = "";
				if(application.getString("appointment_date") != "" && application.getDate("appointment_date") != null)
				{
					Date dateObj =  application.getDate("appointment_date");
					appointmentDate = displayDateFormat.format(dateObj);
				}
				
				applications.add(new ApplicationsBean(application.getInt("application_id"),application.getInt("apartment_id") , application.getInt("user_id"), appointmentDate, application.getString("rescheduled_date"), application.getString("ruled_out_dates"), application.getString("status")));
			}		
		}
	    catch (SQLException e) {
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
		getServletContext().setAttribute("apartments", apartments);
		getServletContext().setAttribute("applications", applications);
		request.getRequestDispatcher("/WEB-INF/jsp/hw1/LookUpApartment.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
