package cs320.hw1.models;

public class ApartmentDetails {

	private  int apartmentID ;
	private String apartmentType;
	private String facility;
	private String maxPeople;
	private String rent;
	private int deposit;
	private String vacancy; // YES or NO, YES if available for renting, else NO
	//private String appointment; // NO,NEW or ACTIVE, YES for if appointment there from user, else NO
	
	
	public ApartmentDetails()
	{
		
	}
	
	public ApartmentDetails(int apartmentID, String apartmentType, String facility,
							String maxPeople, String rent, int deposit, String vacancy)
	{
		this.apartmentID = apartmentID;
		this.apartmentType = apartmentType;
		this.facility = facility;
		this.maxPeople = maxPeople;
		this.rent = rent;
		this.deposit = deposit;
		this.vacancy = vacancy;
		//this.appointment = appointment;
		
	}

	public int getApartmentID() {
		return apartmentID;
	}

	public void setApartmentID(int apartmentID) {
		this.apartmentID = apartmentID;
	}

	public String getApartmentType() {
		return apartmentType;
	}

	public void setApartmentType(String apartmentType) {
		this.apartmentType = apartmentType;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public String getMaxPeople() {
		return maxPeople;
	}

	public void setMaxPeople(String maxPeople) {
		this.maxPeople = maxPeople;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public String getVacancy() {
		return vacancy;
	}

	public void setVacancy(String vacancy) {
		this.vacancy = vacancy;
	}
	
	
}
