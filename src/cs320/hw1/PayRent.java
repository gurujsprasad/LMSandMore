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

@WebServlet("/hw1/PayRent")
public class PayRent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MysqlDB db = new MysqlDB(); 
    public PayRent() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Connection con = db.dbConnection();
		CallableStatement cstmt = null;
		String getRentFormData = "{call GetRentFormDatas ()}";
		String getMonths = "{call GetMonths ()}";
		String getYears = "{call GetYears ()}";
		ArrayList<PayRentBean> payRentBean = new ArrayList<PayRentBean>();
		ArrayList<MonthsBean> months = new ArrayList<MonthsBean>();
		ArrayList<YearsBean> years = new ArrayList<YearsBean>();
		try {
			cstmt = con.prepareCall (getRentFormData);
			ResultSet results = cstmt.executeQuery();
			while(results.next())
			{
				payRentBean.add(new PayRentBean(results.getInt("application_id"), results.getInt("apartment_id"), results.getString("apartment_no"),results.getInt("lease_id"), results.getString("lease_holder_name"), results.getString("rent"), "", "", ""));
			}
			cstmt.close();
			cstmt = con.prepareCall (getMonths);
			results = cstmt.executeQuery();
			while(results.next())
			{
				months.add(new MonthsBean(results.getInt("months_id"), results.getString("month_name")));
			}
			cstmt.close();
			cstmt = con.prepareCall (getYears);
			results = cstmt.executeQuery();
			while(results.next())
			{
				years.add(new YearsBean(results.getInt("year_id"), results.getString("years")));
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
		getServletContext().setAttribute("payRentBean", payRentBean);
		getServletContext().setAttribute("months", months);
		getServletContext().setAttribute("years", years);
		request.getRequestDispatcher("/WEB-INF/jsp/hw1/PayRent.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int leaseID = 0;
		if(request.getParameter("leaseID") != "" || request.getParameter("leaseID") != null)
		{
			leaseID = Integer.parseInt(request.getParameter("leaseID"));
		}
		
		String rentPaid = request.getParameter("rentPaid");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		
		Connection con = db.dbConnection();
		CallableStatement cstmt = null;
		String addRentQuery = "{call AddRent ('"+leaseID+"','"+rentPaid+"','"+month+"','"+year+"')}";
		
		try {
			cstmt = con.prepareCall (addRentQuery);
			cstmt.executeQuery();
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
		response.sendRedirect("ViewApartment");
	}

}
