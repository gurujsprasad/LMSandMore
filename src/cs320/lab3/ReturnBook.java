package cs320.lab3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReturnBook
 */
@WebServlet("/lab3/ReturnBook")
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBook() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		String studentName = request.getParameter("studentName");
		
		ArrayList<BooksModel> books = new ArrayList<BooksModel>();
		books = (ArrayList<BooksModel>)getServletContext().getAttribute("books");
		
		ArrayList<BorrowedBooks> borrowedBooks = new ArrayList<BorrowedBooks>();
		borrowedBooks = (ArrayList<BorrowedBooks>)getServletContext().getAttribute("borrowedBooks");
		
		for (BooksModel book : books)
		{
			if (book.getId() == bookID)
			{
				book.setCopies(book.getCopies()+1);
			}
		}
		
		for (int i=0; i<borrowedBooks.size(); i ++ )
		{
			if (borrowedBooks.get(i).getBookID() == bookID && borrowedBooks.get(i).getStudentName().equals(studentName))
			{
				borrowedBooks.remove(i);
			}
		}
		getServletContext().setAttribute("books", books);
		response.sendRedirect("ViewLibrary");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
