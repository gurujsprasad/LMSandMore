package cs320.finals;

public class MeetingsBean {

	private int meetingID;
	private int timeSlotID;
	private int dayID;
	private String notes;
	public MeetingsBean(int meetingID, int timeSlotID, int dayID, String notes) {
		super();
		this.meetingID = meetingID;
		this.timeSlotID = timeSlotID;
		this.dayID = dayID;
		this.notes = notes;
	}
	public int getMeetingID() {
		return meetingID;
	}
	public void setMeetingID(int meetingID) {
		this.meetingID = meetingID;
	}
	public int getTimeSlotID() {
		return timeSlotID;
	}
	public void setTimeSlotID(int timeSlotID) {
		this.timeSlotID = timeSlotID;
	}
	public int getDayID() {
		return dayID;
	}
	public void setDayID(int dayID) {
		this.dayID = dayID;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
}
