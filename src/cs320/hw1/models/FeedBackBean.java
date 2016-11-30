package cs320.hw1.models;

public class FeedBackBean { //this bean is used to fetch the details from the 
	//apartment_table, user Table and the applications table so that data is presented to the admon to enter the feed back dtails

	private int applicationID;
	private int apartmentID;
	private String apartmentNumber;
	private String leaseHolderName;
	private String rent;
	private String deposit;
	
	public FeedBackBean(int applicationID,int apartmentID, String apartmentNumber,String leaseHolderName, String rent, 
			String deposit)
	{
		this.applicationID = applicationID;
		this.apartmentID = apartmentID;
		this.apartmentNumber = apartmentNumber;
		this.leaseHolderName = leaseHolderName;
		this.rent = rent;
		this.deposit = deposit;
		
	}

	public int getApartmentID() {
		return apartmentID;
	}

	public void setApartmentID(int apartmentID) {
		this.apartmentID = apartmentID;
	}

	public int getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getLeaseHolderName() {
		return leaseHolderName;
	}

	public void setLeaseHolderName(String leaseHolderName) {
		this.leaseHolderName = leaseHolderName;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	
	
}
