package cs320.hw1.models;

public class ApplicationsBean {

	
	private int applicationID;
	private int apartmentID;
	private int userID;
	private String appointmentDate;
	private String rescheduledDate;
	private String ruledOutDates;
	private String status;
	
	public ApplicationsBean(int applicationID,int apartmentID,int userID,String appointmentDate,
			String rescheduledDate,String ruledOutDates,String status)
	{
		this.applicationID = applicationID;
		this.apartmentID = apartmentID;
		this.userID = userID;
		this.appointmentDate = appointmentDate;
		this.rescheduledDate = rescheduledDate;
		this.ruledOutDates = ruledOutDates;
		this.status = status;
	}
	
	public int getApplicationID() {
		return applicationID;
	}
	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}
	public int getApartmentID() {
		return apartmentID;
	}
	public void setApartmentID(int apartmentID) {
		this.apartmentID = apartmentID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getRescheduledDate() {
		return rescheduledDate;
	}
	public void setRescheduledDate(String rescheduledDate) {
		this.rescheduledDate = rescheduledDate;
	}
	public String getRuledOutDates() {
		return ruledOutDates;
	}
	public void setRuledOutDates(String ruledOutDates) {
		this.ruledOutDates = ruledOutDates;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
