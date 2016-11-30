package cs320.lab3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value="/lab3/ViewLibrary", loadOnStartup = 1)
public class ViewLibrary extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int bookID = 1;
       
    
    public ViewLibrary() {
        super();
       
    }

	
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
		ArrayList<BooksModel> books = new ArrayList<BooksModel>();
		books.add(new BooksModel(1, "Tarzan", "GOD", 3));
		books.add(new BooksModel(2, "Tarzan", "GOD", 0));
	
		config.getServletContext().setAttribute("books", books);
		
		ArrayList<BorrowedBooks> borrowedBooks = new ArrayList<BorrowedBooks>();
		borrowedBooks.add(new BorrowedBooks(1, "Tarzan", "Guruprasad"));
	
		config.getServletContext().setAttribute("borrowedBooks", borrowedBooks);
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.getRequestDispatcher("ViewLibrary.jsp").forward(request, response);
		response.sendRedirect("ViewLibrary.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
