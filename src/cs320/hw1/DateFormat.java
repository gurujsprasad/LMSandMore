package cs320.hw1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DateFormat
 */
@WebServlet("/hw1/DateFormat")
public class DateFormat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DateFormat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 String input = "12/23/2014 10:25:";
		 SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		 Date date = null;
		 
		 try {
			date= df.parse(input);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			response.reset();
			response.sendRedirect("Login");
			
		}
		 response.getWriter().println(date);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
