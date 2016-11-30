package cs320.hw1;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
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


@WebServlet("/hw1/FeedBack")
public class FeedBack extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MysqlDB db = new MysqlDB();    
    
    public FeedBack() {
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
		int applicationID = Integer.parseInt(request.getParameter("applicationID"));
		Connection con = db.dbConnection();
		CallableStatement cstmt = null;
		String getApplicationForFeedBackQuery = "{call GetApplicationForFeedBack ('"+applicationID+"')}";
		ArrayList<FeedBackBean> feebBackDetails = new ArrayList<FeedBackBean>();
		
		try {
			cstmt = con.prepareCall (getApplicationForFeedBackQuery);
			ResultSet result = cstmt.executeQuery();
			while(result.next())
			{
				feebBackDetails.add(new FeedBackBean (result.getInt("application_id"),result.getInt("apartment_id"),
						result.getString("apartment_no"),result.getString("user_name"),result.getString("rent"),
						result.getString("deposit")));
			}
			getServletContext().setAttribute("feebBackDetails", feebBackDetails);
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
		request.getRequestDispatcher("/WEB-INF/jsp/hw1/FeedBack.jsp").forward(request, response);
		
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
		int applicationNumber = Integer.parseInt(request.getParameter("applicationNumber"));
		int apartmentID = Integer.parseInt(request.getParameter("apartmentID"));
		String apartmentNumber = request.getParameter("apartmentNumber");
		String leaseTerminationDate = request.getParameter("leaseTerminationDate").trim();
		String leaseHolderName = request.getParameter("leaseName").trim();
		String listOfDocuments = request.getParameter("documents").trim();
		String rent = request.getParameter("rent").trim();
		String deposit = request.getParameter("deposit").trim();
		
		String feedbackDateInvalid = "";
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		Date enteredDate = null;
		
		SimpleDateFormat dbDate = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		String dbInsertDate = "";
		
		Connection con = db.dbConnection();
		CallableStatement cstmt = null;
		
		
		if(leaseTerminationDate != "" && leaseHolderName != "" && listOfDocuments != "" && rent != "" && deposit != "")
		{
			try {
				enteredDate = df.parse(leaseTerminationDate);
			} catch (ParseException e) {
				feedbackDateInvalid = "Please enter the date and in format mm/dd/hh hh:mm:ss";
				request.getSession().setAttribute("feedbackDateInvalid", feedbackDateInvalid);
				response.reset();
				response.sendRedirect("FeedBack?applicationID="+applicationNumber);
			    return;
			}
			Date dateObj =  new Date(leaseTerminationDate);
			dbInsertDate = dbDate.format(dateObj);
			String insertLeaseDataQuery = "{call InsertLeaseData ('"+applicationNumber+"','"+dbInsertDate+"',"
					+ "'"+leaseHolderName+"','"+listOfDocuments+"','"+rent+"','"+deposit+"')}";
			response.getWriter().println(insertLeaseDataQuery);
			try {
				cstmt = con.prepareCall (insertLeaseDataQuery);
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
			//feedback.add(new FeedBackModel(applicationNumber, apartmentNumber, leaseTerminationDate, leaseHolderName, listOfDocuments, rent, deposit));
			response.sendRedirect("ViewAppointment?apartmentID="+apartmentID);
		
		}
		
		else
		{
			feedbackDateInvalid = "Please enter all the details";
			request.getSession().setAttribute("feedbackDateInvalid", feedbackDateInvalid);
			response.reset();
			response.sendRedirect("FeedBack?applicationNumber="+applicationNumber);	
		}
		
		
		
	}

}
