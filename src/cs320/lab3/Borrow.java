package cs320.lab3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/lab3/Borrow")
public class Borrow extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Borrow() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		String title = request.getParameter("title");
		String studentName = request.getParameter("studentName").trim();
		if(studentName != "")
		{
			ArrayList<BooksModel> books = new ArrayList<BooksModel>();
			books = (ArrayList<BooksModel>)getServletContext().getAttribute("books");
			
			ArrayList<BorrowedBooks> borrowedBooks = new ArrayList<BorrowedBooks>();
			borrowedBooks = (ArrayList<BorrowedBooks>)getServletContext().getAttribute("borrowedBooks");
			
			for (BooksModel book : books)
			{
				if (book.getId() == bookID)
				{
					book.setCopies(book.getCopies()-1);
				}
			}
			getServletContext().setAttribute("books", books);	
			
			borrowedBooks.add(new BorrowedBooks(bookID, title, studentName));
			getServletContext().setAttribute("borrowedBooks", borrowedBooks);
			
			response.sendRedirect("ViewLibrary.jsp");
		}
		else
		{
			response.sendRedirect("Borrow.jsp?bookID="+bookID+"&title="+title);
		}
		
		
	}
}
