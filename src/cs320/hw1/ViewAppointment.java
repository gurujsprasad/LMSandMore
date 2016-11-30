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

import cs320.hw1.*;
import cs320.hw1.models.ApartmentTypeBean;
import cs320.hw1.models.ApartmentsBean;
import cs320.hw1.models.ApplicationsBean;
import cs320.hw1.models.ViewApplicationBean;

@WebServlet("/hw1/ViewAppointment")
public class ViewAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MysqlDB db = new MysqlDB();    
  
    public ViewAppointment() {
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
		int apartmentID = 0;
		String appointmentDate = "";
		String needFromDate = "";
		SimpleDateFormat displayDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss"); 
		if(request.getParameter("apartmentID") != "")
		{
			apartmentID = Integer.parseInt(request.getParameter("apartmentID"));
		}
		Connection con = db.dbConnection();
		CallableStatement cstmt = null;
		String viewApartmentQuery = "{call ViewApartment ('"+apartmentID+"')}";
		String viewApplicationsQuery = "{call ViewApplications ('"+apartmentID+"')}";
		String apartmentTypeQuery = "{call ApartmentType ()}";
		
		ArrayList<ApartmentsBean> apartments = new ArrayList<ApartmentsBean>();
		ArrayList<ViewApplicationBean> applications = new ArrayList<ViewApplicationBean>();
		ArrayList<ApartmentTypeBean> apartmentType = new ArrayList<ApartmentTypeBean>();
		
		try {
			cstmt = con.prepareCall (viewApartmentQuery);
			ResultSet apartment = cstmt.executeQuery();
			
			while (apartment.next())
			{
				apartments.add(new ApartmentsBean(apartment.getInt("apartment_id"),apartment.getString("apartment_no"),apartment.getString("apartment_type"),apartment.getString("facility"),apartment.getString("max_people"),apartment.getInt("rent"),apartment.getInt("deposit"),apartment.getString("vacancy")));
			}
			cstmt.close();
			cstmt = con.prepareCall (viewApplicationsQuery);
			ResultSet application = cstmt.executeQuery();
			while(application.next())
			{
				needFromDate = "";
				appointmentDate = "";
				if(application.getString("need_from_date") != "" && application.getString("need_from_date") != null)
				{
					Date dateObj =  application.getDate("need_from_date");
					needFromDate = displayDateFormat.format(dateObj);
				}
				if( application.getString("appointment_date") != "" && application.getString("appointment_date") != null)
				{
					Date dateObj =  application.getDate("appointment_date");
					appointmentDate = displayDateFormat.format(dateObj);
				}
				applications.add(new ViewApplicationBean(application.getInt("application_id"),application.getString("user_name") , application.getString("phone_number"), application.getString("no_of_people"),
						application.getString("occupation"), application.getString("preference"), needFromDate,appointmentDate
						, application.getString("rescheduled_date"), application.getString("ruled_out_dates"),application.getString("status")));
			}
			cstmt.close();
			cstmt = con.prepareCall (apartmentTypeQuery);
			ResultSet result = cstmt.executeQuery();
			while(result.next())
			{
				apartmentType.add(new ApartmentTypeBean(result.getInt("apt_type_id"), result.getString("apt_type_value")));
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
		getServletContext().setAttribute("ViewApartment", apartments);
		getServletContext().setAttribute("viewApplications", applications);
		getServletContext().setAttribute("apartmentType", apartmentType);
		request.getRequestDispatcher("/WEB-INF/jsp/hw1/ViewAppointment.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
