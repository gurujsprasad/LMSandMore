package cs320.finals;

public class FetchMeetingForEditBean {

	private int meetingID;
	private String day;
	private String timeSlot;
	private String notes;
	public FetchMeetingForEditBean(int meetingID, String day, String timeSlot, String notes) {
		super();
		this.meetingID = meetingID;
		this.day = day;
		this.timeSlot = timeSlot;
		this.notes = notes;
	}
	public int getMeetingID() {
		return meetingID;
	}
	public void setMeetingID(int meetingID) {
		this.meetingID = meetingID;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
}
