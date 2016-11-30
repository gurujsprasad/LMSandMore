package cs320.hw1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.hw1.*;
import cs320.hw1.models.*;

@WebServlet("/hw1/ViewApartment")
public class ViewApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MysqlDB db = new MysqlDB();   
 
    public ViewApartment() {
        super();
       
    }

	@SuppressWarnings("unchecked")
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
		ArrayList<ApartmentsBean> apartments = new ArrayList<ApartmentsBean>();
		String fetchApartmentsQuery = "{call GetApartments ()}";
		try {
			cstmt = con.prepareCall (fetchApartmentsQuery);
			ResultSet apartment = cstmt.executeQuery();
			
			while (apartment.next())
			{
				apartments.add(new ApartmentsBean(apartment.getInt("apartment_id"),apartment.getString("apartment_no"),apartment.getString("apartment_type"),apartment.getString("facility"),apartment.getString("max_people"),apartment.getInt("rent"),apartment.getInt("deposit"),apartment.getString("vacancy")));
			}
			cstmt.close();
			con.close();
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
		request.getRequestDispatcher("/WEB-INF/jsp/hw1/ViewApartment.jsp").forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
