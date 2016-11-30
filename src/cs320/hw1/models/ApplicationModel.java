package cs320.hw1.models;

import java.util.ArrayList;

public class ApplicationModel {
	
	int applicationNumber;
	ApartmentDetails appartmentInfo;	
	ApartmentUsers userInfo;
	String appointmentDate; 
	String status;
	String rescheduledDate;
	String ruledOutDates;
	ArrayList<String> ruledOutDate = new ArrayList<String>();
	
	public ApplicationModel()
	{
		 this.ruledOutDate = new ArrayList<String>();
	}
	
	
	public ApplicationModel (int applicationNumber,ApartmentDetails appartmentInfo, ApartmentUsers userInfo, String appointmentDate,
			String status, String rescheduledDate,String ruledOutDates)
	{
		 this.applicationNumber =applicationNumber;
		 this.appartmentInfo = appartmentInfo;	
		 this.userInfo = userInfo;	
		 
		 this.appointmentDate = appointmentDate;
		 this.status = status; //ACCEPTED or DENIED or REQUESTED or WAITINGRESPONSE
		 this.rescheduledDate = rescheduledDate;
		 this.ruledOutDate = new ArrayList<String>();
		 //this.appartmentStatus = appartmentStatus; //status of appartment, "NO" "VACANT"
		
	}
	
	public ApartmentDetails getAppartmentInfo() {
		return appartmentInfo;
	}


	public void setAppartmentInfo(ApartmentDetails appartmentInfo) {
		this.appartmentInfo = appartmentInfo;
	}


	public ArrayList<String> getRuledOutDate() {
		return ruledOutDate;
	}

	public void setRuledOutDate(ArrayList<String> ruledOutDate) {
		this.ruledOutDate = ruledOutDate;
	}

	public void setRuledOutDate(String ruledOutDate) {
		this.ruledOutDate.add(ruledOutDate);
	}
	
	
	public ApartmentUsers getUserInfo() {
		return userInfo;
	}


	public void setUserInfo(ApartmentUsers userInfo) {
		this.userInfo = userInfo;
	}
	
	public int getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(int applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
