package cs320.hw1.models;

public class YearsBean {

	int yearID;
	String year;
	
	public YearsBean( int yearID, String year)
	{
		this.yearID = yearID;
		this.year = year;
	}

	public int getYearID() {
		return yearID;
	}

	public void setYearID(int yearID) {
		this.yearID = yearID;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
}
