package cs320.finals;

public class DaysBean {

	private int dayID;
	private String day;
	public DaysBean(int dayID, String day) {
		super();
		this.dayID = dayID;
		this.day = day;
	}
	public int getDayID() {
		return dayID;
	}
	public void setDayID(int dayID) {
		this.dayID = dayID;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	
}
