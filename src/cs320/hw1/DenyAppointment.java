package cs320.hw1;

import java.io.IOException;
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

import cs320.hw1.models.*;


@WebServlet("/hw1/DenyAppointment")
public class DenyAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MysqlDB db = new MysqlDB();
    public DenyAppointment() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int applicationID = Integer.parseInt(request.getParameter("applicationNumber"));
		String residentDecision = request.getParameter("decision");
		try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
		
		String acceptAppointmentQuery = "{call AcceptAppointment ('"+applicationID+"')}";
		String denyAppointmentQuery = "{call DenyAppointment ('"+applicationID+"')}";
		
		if(residentDecision.equals(ResidentAppointmentDecision.ACCEPT.toString()))
		{
			Connection con = db.dbConnection();
			CallableStatement cstmt = null;
			try {
				cstmt = con.prepareCall (acceptAppointmentQuery);
				cstmt.executeQuery();
				cstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
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
		if(residentDecision.equals(ResidentAppointmentDecision.REJECT.toString()))
		{
			Connection con = db.dbConnection();
			CallableStatement cstmt = null;
			try {
				cstmt = con.prepareCall (denyAppointmentQuery);
				cstmt.executeQuery();
				cstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
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
		response.sendRedirect("LookUpApartment");
	}
	

}
