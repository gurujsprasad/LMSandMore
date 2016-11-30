package cs320.hw1.models;

public class MonthsBean {

	private int monthID;
	private String month;
	
	public MonthsBean (int monthID, String month)
	{
		this.monthID = monthID;
		this.month =  month;
	}

	public int getMonthID() {
		return monthID;
	}

	public void setMonthID(int monthID) {
		this.monthID = monthID;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
}
