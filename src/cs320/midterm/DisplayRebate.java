package cs320.midterm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value = "/midterm/DisplayRebate", loadOnStartup = 1)
public class DisplayRebate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DisplayRebate() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		ArrayList<ItemsModel> items = new ArrayList<ItemsModel>();
		Date date= new Date();
		items.add(new ItemsModel("SD Card", "ME", 100,date,"false"));
		items.add(new ItemsModel("Mouse", "ME", 7,date,"false"));
		items.add(new ItemsModel("Key Board", "Guru", 8,date,"false"));
		items.add(new ItemsModel("I Pad", "Guru", 500,date,"false"));
		config.getServletContext().setAttribute("items", items);
		
		ArrayList<UserModel> users = new ArrayList<UserModel>();
		users.add(new UserModel ("ME"));
		users.add(new UserModel("Guru"));
		config.getServletContext().setAttribute("users", users);
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/midterm/DisplayRebate.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userSelect = request.getParameter("userSelect");
		request.getSession().setAttribute("userSelect",userSelect);
		request.getRequestDispatcher("/midterm/DisplayRebate.jsp").forward(request, response);
	}

}
