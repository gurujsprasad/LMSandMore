package cs320.finals;

public class TimeSlotsBean {

	private int timeSlotID;
	private String timeSlot;
	public TimeSlotsBean(int timeSlotID, String timeSlot) {
		super();
		this.timeSlotID = timeSlotID;
		this.timeSlot = timeSlot;
	}
	public int getTimeSlotID() {
		return timeSlotID;
	}
	public void setTimeSlotID(int timeSlotID) {
		this.timeSlotID = timeSlotID;
	}
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
	
	
}
