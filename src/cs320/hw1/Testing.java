package cs320.hw1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.hw1.models.ApartmentDetails;
import cs320.hw1.models.ApplicationModel;


@WebServlet("/Testing")
public class Testing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Testing() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		ArrayList<ApplicationModel> applications = new ArrayList<ApplicationModel> ();
		applications = (ArrayList<ApplicationModel>) getServletContext().getAttribute("applications");
		
		ArrayList<ApartmentDetails> apartments = new ArrayList<ApartmentDetails> ();
		apartments = (ArrayList<ApartmentDetails>) getServletContext().getAttribute("apartmentDetails");
		
		out.println("<html><body>");
		int sizeOf = applications.size();
		out.println("<p>Apartment Details</p>");
		for(ApartmentDetails apartment : apartments)
		{
			out.println("<p>ID: "+apartment.getApartmentID()+"</p>");
			//out.println("<p>appointment status:"+apartment.getAppointment()+"</p>");
		}
		
		
		
		out.println("<p>number of applications = "+sizeOf+"</p>");
		out.println("<table>");
		//out.println("<tr></tr>");
		
		
		
		
		for (ApplicationModel application : applications)
		{
			out.println("<tr><td>"+application.getUserInfo().getEmailID()+"</td><td>"+application.getApplicationNumber()+"</td><td>"+application.getAppartmentInfo().getApartmentID()+"</td><td>"+application.getAppartmentInfo().getDeposit()+"</td><td>"+application.getUserInfo().getEmailID()+"</td><td>"+application.getUserInfo().getUsername()+"</td><td>"+application.getApplicationNumber()+"</td><td>"+application.getAppointmentDate()+"</td><td>"+application.getStatus()+"</td><td>"+application.getUserInfo().getOccupation()+"</td></tr>");
			
			
		}
		out.println("</table></body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
