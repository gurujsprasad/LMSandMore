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

import cs320.hw1.models.*;


@WebServlet("/hw1/FeedBackView")
public class FeedBackView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MysqlDB db = new MysqlDB();  
    
    public FeedBackView() {
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
		int applicationID = 0;
		if(request.getParameter("apID") != "")
		{
			applicationID = Integer.parseInt(request.getParameter("apID"));
		}
		String ViewFeedBackDisplayQuery = "{call GetFeedBackLeaseData ('"+applicationID+"')}";
		Connection con = db.dbConnection();
		CallableStatement cstmt = null;
		ArrayList<ViewFeebBackBean> feedback = new ArrayList<ViewFeebBackBean>();
		try {
			cstmt = con.prepareCall (ViewFeedBackDisplayQuery);
			ResultSet results = cstmt.executeQuery();
			while (results.next())
			{
				feedback.add(new ViewFeebBackBean(results.getInt("application_id"),results.getInt("apartment_id"), results.getString("apartment_no"), results.getString("lease_holder_name"), results.getString("lease_termination_date"), results.getString("list_of_documents"), results.getString("rent"), results.getString("deposit")));
			}
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
		getServletContext().setAttribute("feedback", feedback);
		request.getRequestDispatcher("/WEB-INF/jsp/hw1/FeedBackView.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
