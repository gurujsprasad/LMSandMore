package cs320.hw1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.hw1.models.*;
import cs320.hw1.*;


@WebServlet(value = "/hw1/AddApartment")
public class AddApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String registrationFormDetailInvalid = "";
	MysqlDB db = new MysqlDB();  
   
    public AddApartment() {
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
		CallableStatement cstmt = null;
		
		String apartmentTypeQuery = "{call ApartmentType ()}";
		ArrayList<ApartmentTypeBean> apartments = new ArrayList<ApartmentTypeBean>();
		
		try {
			cstmt = con.prepareCall (apartmentTypeQuery);
			ResultSet apartmentType = cstmt.executeQuery();
			while(apartmentType.next())
			{
				apartments.add(new ApartmentTypeBean(apartmentType.getInt("apt_type_id"), apartmentType.getString("apt_type_value")));
			}
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
		request.getRequestDispatcher("/WEB-INF/jsp/hw1/AddApartment.jsp").forward(request, response);
		
	}

	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
		int deposit = 0;
		int rent = 0;
		String aptnumber = request.getParameter("aptnumber").trim();
		
		String appartmentType = request.getParameter("apartmentType");
		String facilities = request.getParameter("facilities").trim();
		String maxPeople = request.getParameter("maxPeople").trim();
		if(request.getParameter("rent").trim() != "")
		{
			rent = Integer.parseInt(request.getParameter("rent").trim());
		}
		
		if(request.getParameter("deposit").trim() != "")
		{
			deposit = Integer.parseInt(request.getParameter("deposit").trim());
		}
		
		if(aptnumber != "" && facilities != "" && maxPeople != "" && rent  != 0  && deposit  != 0 )
		{
			Connection con = db.dbConnection();
			CallableStatement cstmt = null;
			
			String addApartmentQuery = "{call AddApartment ('"+aptnumber+"','"+appartmentType+"','"+facilities+"',"
					+ "'"+maxPeople+"','"+rent+"','"+deposit+"','"+ApartmentStatus.VACANT.toString()+"')}";
			try {
				cstmt = con.prepareCall (addApartmentQuery);
				if(cstmt.executeQuery() != null)
				{
					response.sendRedirect("ViewApartment");
				}
			} catch (SQLException e) {
				registrationFormDetailInvalid = "Addition of Apartment failed from DB end !!";
				request.setAttribute("registrationFormDetailInvalid", registrationFormDetailInvalid); 
				request.getRequestDispatcher("/WEB-INF/jsp/hw1/AddApartment.jsp").forward(request, response);
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
			registrationFormDetailInvalid = "Enter all the details in the form";
			request.setAttribute("registrationFormDetailInvalid", registrationFormDetailInvalid);
			request.getRequestDispatcher("/WEB-INF/jsp/hw1/AddApartment.jsp").forward(request, response);		
		}		
	}
}
