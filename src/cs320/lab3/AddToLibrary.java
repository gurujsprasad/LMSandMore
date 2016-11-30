package cs320.lab3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.hw1.models.ApartmentDetails;


@WebServlet("/lab3/AddToLibrary")
public class AddToLibrary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddToLibrary() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("AddToLibrary.jsp");
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bookID = 0;
		if(request.getParameter("bookID").trim() != "")
		{
			bookID = Integer.parseInt(request.getParameter("bookID").trim());
		}
		String title = request.getParameter("title").trim();
		String Author = request.getParameter("Author").trim();
		int copies = 0;
		if(request.getParameter("copies").trim() != "")
		{
			copies = Integer.parseInt(request.getParameter("copies").trim());
		}
		
		if(bookID != 0 && title != ""  && Author != "" && copies != 0)
		{
			ArrayList<BooksModel> books = new ArrayList<BooksModel>();
			books = (ArrayList<BooksModel>)getServletContext().getAttribute("books");
			books.add(new BooksModel(bookID,title,Author,copies));
			getServletContext().setAttribute("books", books);
			response.sendRedirect("ViewLibrary.jsp");
		}
		else
		{
			response.sendRedirect("AddToLibrary.jsp");
		}
		
	}

}
