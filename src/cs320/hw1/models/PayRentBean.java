package cs320.hw1.models;

public class PayRentBean {

	private int applicationID;
	private int apartmentID;
	private String apartmentNo;
	private int leaseID;
	private String username;
	private String rent;
	private String rentPaid;
	private String month;
	private String year;
	
	public PayRentBean(int applicationID, int apartmentID, String aparmtentNo,int leaseID,String username, String rent, String rentPaid,
			String month,String year)
	{
		 this.applicationID = applicationID;
		 this. apartmentID = apartmentID;
		 this.apartmentNo = aparmtentNo;
		 this.leaseID = leaseID;
		 this.username = username;	 
		 this.rent = rent;
		 this.rentPaid = rentPaid;
		 this.month = month;
		 this.year= year;
		 
	}

	public String getApartmentNo() {
		return apartmentNo;
	}

	public void setApartmentNo(String apartmentNo) {
		this.apartmentNo = apartmentNo;
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

	public int getLeaseID() {
		return leaseID;
	}

	public void setLeaseID(int leaseID) {
		this.leaseID = leaseID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public String getRentPaid() {
		return rentPaid;
	}

	public void setRentPaid(String rentPaid) {
		this.rentPaid = rentPaid;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
}
