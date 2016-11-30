package cs320.hw1.models;

public class ApartmentTypeBean {

	 int apartmentID;
	 String apartmentType;
	
	public ApartmentTypeBean(int apartmentID, String apartmentType)
	{
		this.apartmentID = apartmentID;
		this.apartmentType = apartmentType;
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
	
}
