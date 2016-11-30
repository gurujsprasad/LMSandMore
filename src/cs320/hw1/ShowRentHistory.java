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

import cs320.hw1.*;
import cs320.hw1.models.*;

@WebServlet("/hw1/ShowRentHistory")
public class ShowRentHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MysqlDB db = new MysqlDB(); 
    public ShowRentHistory() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Connection con = db.dbConnection();
		CallableStatement cstmt = null;
		String addRentQuery = "{call GetRentDataDisplay ()}";
		ArrayList<PayRentBean> rentDisplay = new ArrayList<PayRentBean>(); 
		try {
			cstmt = con.prepareCall (addRentQuery);
			ResultSet results = cstmt.executeQuery();
			while (results.next())
			{
				rentDisplay.add(new PayRentBean(0, 0, results.getString("apartment_no"), 0, results.getString("lease_holder_name"), results.getString("rent"), results.getString("rent_paid"), results.getString("month"), results.getString("year")));
			}
		} catch (SQLException e) {
			
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
					
					e.printStackTrace();
				} 
			}
		}
		
		getServletContext().setAttribute("rentDisplay", rentDisplay);
		request.getRequestDispatcher("/WEB-INF/jsp/hw1/ShowRent.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
