package cs320.midterm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/midterm/ReceiveRebate")
public class ReceiveRebate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ReceiveRebate() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String itemname = request.getParameter("itemName");
		String username = request.getParameter("userName");
		response.getWriter().println("itemname"+itemname+"username"+username);
		
		ArrayList<ItemsModel> items = new ArrayList<ItemsModel>();
		Date date= new Date();
		items = (ArrayList<ItemsModel>) getServletContext().getAttribute("items");
		for(ItemsModel item : items)
		{
			if (item.getItemName().equals(itemname) && item.getUser().equals(username))
			{
				item.setReceivedFlag("true");
				item.setRecievedDate(date);
			}
		}
		getServletContext().setAttribute("items", items);
		response.sendRedirect("DisplayRebate.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
