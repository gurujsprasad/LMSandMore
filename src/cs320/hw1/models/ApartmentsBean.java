package cs320.hw1.models;

public class ApartmentsBean {

	private int apartmentID;
	private String apartmentNumber;
	private String apartmentType;
	private String facility;
	private String maxPeople;
	private int rent;
	private int deposit;
	private String vacancy; 
	
	public ApartmentsBean(int aptID,String aptNo,String aptType,String fac,String people,int rnt,int dpt,String vac)
	{
		this.apartmentID = aptID;
		this.apartmentNumber = aptNo;
		this.apartmentType = aptType;
		this.facility = fac;
		this.maxPeople = people;
		this.rent = rnt;
		this.deposit = dpt;
		this.vacancy = vac;
	}

	public int getApartmentID() {
		return apartmentID;
	}

	public void setApartmentID(int apartmentID) {
		this.apartmentID = apartmentID;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
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

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
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
