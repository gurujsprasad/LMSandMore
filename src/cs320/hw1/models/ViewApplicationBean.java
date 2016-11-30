package cs320.hw1.models;

public class ViewApplicationBean {

	private int applicationID;
	private String username;
	private String phoneNumber;
	private String noOfPeople;
	private String occupation;
	private String preference;
	private String needFromDate;
	private String appointmendDate;
	private String rescheduledDate;
	private String ruledOutDates;
	private String status;
	
	public ViewApplicationBean(int applicationID,String username,String phoneNumber,String noOfPeople
			,String occupation,String preference,String needFromDate, String appointmendDate,
			String rescheduledDate,String ruledOutDates, String status)
	{
		this.applicationID = applicationID;
		this.username = username;
		this.phoneNumber = phoneNumber;
		this.noOfPeople = noOfPeople;
		this.occupation = occupation;
		this.preference = preference;
		this.needFromDate = needFromDate;
		this.appointmendDate = appointmendDate;
		this.rescheduledDate = rescheduledDate;
		this.ruledOutDates = ruledOutDates;
		this.status = status;
	}
	public String getAppointmendDate() {
		return appointmendDate;
	}
	public void setAppointmendDate(String appointmendDate) {
		this.appointmendDate = appointmendDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(String noOfPeople) {
		this.noOfPeople = noOfPeople;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	public String getNeedFromDate() {
		return needFromDate;
	}

	public void setNeedFromDate(String needFromDate) {
		this.needFromDate = needFromDate;
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

	
}
