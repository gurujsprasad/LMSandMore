package cs320.lab7;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GradeCalculator
 */
@WebServlet("/lab7/GradeCalculator")
public class GradeCalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeCalculator() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/lab7/GradeCalculator.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String homeWork0 = request.getParameter("homework0");
		String homeWork1 = request.getParameter("homework1");
		String homeWork2 = request.getParameter("homework2");
		String homeWork3 = request.getParameter("homework3");
		String homeWork4 = request.getParameter("homework4");
		String lab1 = request.getParameter("lab1");
		String lab2 = request.getParameter("lab2");
		String lab3 = request.getParameter("lab3");
		String lab4 = request.getParameter("lab4");
		String lab5 = request.getParameter("lab5");
		String lab6 = request.getParameter("lab6");
		String totalHomeWork = request.getParameter("totalPoints");
		String totalLab = request.getParameter("totalLab");
		
		String midtermUsersTotal = request.getParameter("midtermUsersTotal");
		String midtermTotal = request.getParameter("midtermTotal");
		
		String finalUsersTotal = request.getParameter("finalUsersTotal");
		String FinalTotal = request.getParameter("FinalTotal");
		String attendance = request.getParameter("attendance");
		
		
		
		
		if( homeWork0 != "" && homeWork1  != "" && homeWork2  != "" && homeWork3  != ""   && homeWork4  != ""  && lab1 != ""   && lab2  != ""  && 
				lab3  != ""  && lab4  != "" &&  
				lab5  != ""  && lab6  != ""  && totalHomeWork  != "" && totalLab != ""  && midtermUsersTotal != ""  && 
				midtermTotal != ""  &&  finalUsersTotal  != "" && FinalTotal  != ""  && (attendance != "") )
		{
			int homeWorkPercentage = Integer.parseInt(homeWork0)+Integer.parseInt(homeWork1)+Integer.parseInt(homeWork2)+Integer.parseInt(homeWork3)+Integer.parseInt(homeWork4);
			homeWorkPercentage = ( homeWorkPercentage * 100 )/Integer.parseInt(totalHomeWork);
			homeWorkPercentage = (homeWorkPercentage * 35)/100;
			//response.getWriter().println(homeWorkPercentage);
			
			int totalLabPercentage = Integer.parseInt(lab1)+
					Integer.parseInt(lab2)+Integer.parseInt(lab3)+Integer.parseInt(lab4)+Integer.parseInt(lab5)+Integer.parseInt(lab6);
			totalLabPercentage = (totalLabPercentage * 100) / Integer.parseInt(totalLab);
			totalLabPercentage = (totalLabPercentage * 20 ) / 100;
			 //homeWorkPercentage = ( (330 *100) / 500);
			
			int midtermPercentage = (Integer.parseInt(midtermUsersTotal) * 100) / Integer.parseInt(midtermTotal);
			midtermPercentage = (midtermPercentage * 20)/100;
			
			int finalPercentage = (Integer.parseInt(finalUsersTotal) * 100) / Integer.parseInt(FinalTotal);
			finalPercentage = (finalPercentage * 20)/100;
			
			int total = midtermPercentage +totalLabPercentage+ finalPercentage + homeWorkPercentage + Integer.parseInt(attendance);
			request.setAttribute("total", total);
			request.getRequestDispatcher("/WEB-INF/jsp/lab7/GradeCalculator.jsp").forward(request, response);
		}
		
		else
		{
			String emptyFieldError = "Please Enter all the fields";
			request.setAttribute("emptyFieldError", emptyFieldError);
			request.getRequestDispatcher("/WEB-INF/jsp/lab7/GradeCalculator.jsp").forward(request, response);
		}
	}

}
