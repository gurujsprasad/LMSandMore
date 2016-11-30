package cs320.hw1.models;

public class ViewFeebBackBean {
	private int applicationID;
	private int apartmentID;
	private String apartmentNumber;
	private String leaseHolderName;
	private String leaseTermintationDate;
	private String leaseDocuments;
	private String rent;
	private String deposit;
	
	public ViewFeebBackBean(int applicationID,int apartmentID, String apartmentNumber,
			String leaseHolderName, String leaseTermintationDate, String leaseDocuments, String rent, 
			String deposit)
	{
		this.applicationID = applicationID;
		this.apartmentID = apartmentID;
		this.apartmentNumber = apartmentNumber;
		this.leaseHolderName = leaseHolderName;
		this.leaseTermintationDate = leaseTermintationDate;
		this.leaseDocuments = leaseDocuments;
		this.rent = rent;
		this.deposit = deposit;
		
	}

	public int getApartmentID() {
		return apartmentID;
	}

	public void setApartmentID(int apartmentID) {
		this.apartmentID = apartmentID;
	}

	public String getLeaseTermintationDate() {
		return leaseTermintationDate;
	}

	public void setLeaseTermintationDate(String leaseTermintationDate) {
		this.leaseTermintationDate = leaseTermintationDate;
	}

	public String getLeaseDocuments() {
		return leaseDocuments;
	}

	public void setLeaseDocuments(String leaseDocuments) {
		this.leaseDocuments = leaseDocuments;
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
