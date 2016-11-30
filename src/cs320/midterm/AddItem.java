package cs320.midterm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/midterm/AddItem")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String itemname = request.getParameter("itemname");
		int amount = 0;
		String emptyField = "";
		if(request.getParameter("amount") != "" && request.getParameter("amount") != null)
		{
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		
		String username = request.getParameter("username");
		
		if(itemname != "" && itemname != null)
		{
			ArrayList<ItemsModel> items = new ArrayList<ItemsModel>();
			Date date= new Date();
			items = (ArrayList<ItemsModel>) getServletContext().getAttribute("items");
			items.add(new ItemsModel(itemname,username, amount,date,"false"));
			getServletContext().setAttribute("items", items);
			response.sendRedirect("DisplayRebate.jsp");
		}
		else
		{
			emptyField = "Please enter all the fields while adding Items";
			request.getSession().setAttribute("emptyField", emptyField);
			response.sendRedirect("DisplayRebate.jsp");
		}
		
	}

}
