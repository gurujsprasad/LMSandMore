package cs320.hw1.models;

public class ApartmentUsers {
	
	private String emailID;
	private String password;
	private String username;
	private String phoneNumber;
	private String noOfPeople;
	private String occupation;
	private String houseType;
	private String preference;
	private String date;
	private String userType;
	
	public ApartmentUsers()
	{
		
	}
	
	public ApartmentUsers(String emailID,String password,String username,String phoneNumber,
							String noOfPeople,String occupation,String houseType,String preference,
							String date,String userType)
	{
		this.emailID = emailID;
		this.password = password;
		this.username = username;
		this.phoneNumber = phoneNumber;
		this.noOfPeople = noOfPeople;
		this.occupation = occupation;
		this.houseType = houseType;
		this.preference = preference;
		this.date = date;
		this.userType = userType;
		
	}

	public ApartmentUsers(String emailID, String applicantName, String contactNumber, String numberOfPeople,
			String occupation,String preferences, String needFromDate)
	{
		this.emailID = emailID;
		this.username = applicantName;
		this.phoneNumber = contactNumber;
		this.noOfPeople = numberOfPeople;
		this.occupation = occupation;
		this.houseType = occupation;
		this.preference = preferences;
		this.date = needFromDate;
	}
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	

}
