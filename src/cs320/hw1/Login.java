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
import javax.servlet.http.HttpSession;

import cs320.hw1.models.*;
import cs320.hw1.*;


@WebServlet(value = "/hw1/Login", loadOnStartup = 1)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MysqlDB db = new MysqlDB();
    public Login() {
        super();
       
    }


	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		 try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
	
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/hw1/Login.jsp").forward(request, response);
		
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
		// DB related objects
		Connection con = db.dbConnection();
		CallableStatement cstmt = null;
		
		// user related objects
		String userLoginQuery = "";
		String emailID = request.getParameter("emailID").trim();
		String password = request.getParameter("pwd").trim();
		String username = "";
		String userType = "";
		int userID = 0;
		String invalidLogin = ""; // validating login page
		
		//to check valid login
		int flag = 0;
		
		if(emailID != "" && password != "")
		{
			userLoginQuery = "{call UserLogin ('"+emailID+"','"+password+"')}";
			try {
				cstmt = con.prepareCall (userLoginQuery);
				ResultSet userData = cstmt.executeQuery();
				if(userData.next())
				{
					flag = 1;
					userID = userData.getInt("user_id");
					username = userData.getString("user_name");
					userType = userData.getString("user_type");
				}
				if (flag ==1)
				{
					request.getSession().setAttribute("emailID", emailID);
					request.getSession().setAttribute("username",username );
					request.getSession().setAttribute("userType",userType);	
					request.getSession().setAttribute("userID",userID);	
				}
				if(userType.equals(UserType.ADMIN.toString()))
				{
					response.sendRedirect("ManagerHome");
				}
				if(userType.equals(UserType.USER.toString()))
				{
					response.sendRedirect("LookUpApartment");					
				}
				if(flag == 0)
				{
					invalidLogin = "Email id or password is not correct, please try again";
					request.setAttribute("emptyFields", invalidLogin);
					request.getRequestDispatcher("/WEB-INF/jsp/hw1/Login.jsp").forward(request, response);
				}
				
			} catch (SQLException e) {
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
		}
		else
		{
			invalidLogin = "Email ID and password field should not be empty";
			request.setAttribute("emptyFields", invalidLogin);
			request.getRequestDispatcher("/WEB-INF/jsp/hw1/Login.jsp").forward(request, response);
		}
	}
}
