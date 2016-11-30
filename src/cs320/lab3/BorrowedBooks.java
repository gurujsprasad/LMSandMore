package cs320.lab3;

import java.util.Date;

public class BorrowedBooks {

	private int bookID;
	private String title;
	private String studentName;
	private Date borrowedDate;
	
	public BorrowedBooks(int bookID,String title,String studentName)
	{
		this.bookID =  bookID;
		this.title = title;
		this.studentName = studentName;
		this.borrowedDate = new Date();
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}
	
	
}
