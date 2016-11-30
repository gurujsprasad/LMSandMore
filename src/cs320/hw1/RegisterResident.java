package cs320.hw1;

import java.io.IOException;
import java.io.PrintWriter;
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
import cs320.hw1.*;


@WebServlet("/hw1/RegisterResident")
public class RegisterResident extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	private String invalidDate = "";
	MysqlDB db = new MysqlDB();
    public RegisterResident() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = db.dbConnection();
		CallableStatement cstmt = null;
		try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
		String occupationQuery = "{call UserOccupation ()}";
		String apartmentTypeQuery = "{call ApartmentType ()}";
		
		ArrayList<ApartmentTypeBean> apartments = new ArrayList<ApartmentTypeBean>();
		ArrayList<UserOccupationBean> occupations = new ArrayList<UserOccupationBean>();
		
		try {
			cstmt = con.prepareCall (occupationQuery);
			ResultSet occupation = cstmt.executeQuery();
			
			while (occupation.next())
			{
				occupations.add(new UserOccupationBean (occupation.getInt("occupation_id"),occupation.getString("occupation_value")));
			}
			cstmt.close();
			
			cstmt = con.prepareCall (apartmentTypeQuery);
			ResultSet apartmentType = cstmt.executeQuery();
			while(apartmentType.next())
			{
				apartments.add(new ApartmentTypeBean(apartmentType.getInt("apt_type_id"), apartmentType.getString("apt_type_value")));
			}
			getServletContext().setAttribute("occupations", occupations);
			getServletContext().setAttribute("apartments", apartments);
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
	request.getRequestDispatcher("/WEB-INF/jsp/hw1/RegisterResident.jsp").forward(request, response);
	
	}

	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int insertSuccessFlag = 0;
		try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
		ArrayList<ApartmentUsers> apartmentUsers = new ArrayList<ApartmentUsers>();
		apartmentUsers = (ArrayList<ApartmentUsers>) getServletContext().getAttribute("apartmentUsers");
		String username = request.getParameter("username").trim() ;
		String password = request.getParameter("pwd").trim();
		String confirmPassword = request.getParameter("cpwd").trim();
		String emailID = request.getParameter("emailID").trim();
		String mobile = request.getParameter("mobile").trim() ;
		String people = request.getParameter("people").trim();
		String occupation = request.getParameter("occupation").trim();
		String apartmentType = request.getParameter("apartmentType").trim();
		String preferences = request.getParameter("preferences").trim();
		String date = request.getParameter("date").trim();
		
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		SimpleDateFormat dbDate = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		Date enteredDate = null;	
		String dbInsertDate = "";
		String userType = UserType.USER.toString();
		
		String registrationInvalid = ""; 
		
		if(username != "" && password != "" && confirmPassword != "" && emailID != "" && mobile != "" && people != "" && occupation != "" && apartmentType != "" && preferences != "" && date != "")
		{
			if (password.equals(confirmPassword))
			{
					try {
						 enteredDate = df.parse(date);
					
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							registrationInvalid = "Date format is not right, Please enter the formate given in the example";
							request.setAttribute("registrationInvalid", registrationInvalid);
							request.getRequestDispatcher("/WEB-INF/jsp/hw1/RegisterResident.jsp").forward(request, response);
						    return;
							//doGet(request, response);
							
						}
				Date dateObj =  new Date(date);
				dbInsertDate = dbDate.format(dateObj);
				// inserting date in to DB
				Connection con = db.dbConnection();
				CallableStatement cstmt = null;
				
				String userRegistrationQuery = "{call UserRegistration ('"+emailID+"','"+password+"','"+username+"',"
						+ "'"+mobile+"','"+people+"','"+occupation+"','"+apartmentType+"','"+preferences+"','"+dbInsertDate
						+"','"+userType+"')}";
				//response.getWriter().print(userRegistrationQuery);
			
				try {
					cstmt = con.prepareCall (userRegistrationQuery);
					if(cstmt.executeQuery() != null)
						{
							registrationInvalid = "Registration Successful, Please Login again to continue further";
							request.setAttribute("registrationInvalid", registrationInvalid);
							request.getRequestDispatcher("/WEB-INF/jsp/hw1/Login.jsp").forward(request, response);
						}
					
				} catch (SQLException e) {
					registrationInvalid = "Failed to create new user from DB end !! ";
					request.setAttribute("registrationInvalid", registrationInvalid);
					request.getRequestDispatcher("/WEB-INF/jsp/hw1/RegisterResident.jsp").forward(request, response);
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
				
			}
			else
			{
				registrationInvalid = "Password entered does'nt match with confirm password field";
				request.setAttribute("registrationInvalid", registrationInvalid);
				request.getRequestDispatcher("/WEB-INF/jsp/hw1/RegisterResident.jsp").forward(request, response);
			}
		}
		else
		{
			registrationInvalid = "Enter all the fields";
			request.setAttribute("registrationInvalid", registrationInvalid);
			request.getRequestDispatcher("/WEB-INF/jsp/hw1/RegisterResident.jsp").forward(request, response);
		}
	}  

}
