package cs320.hw1.models;

public class UserOccupationBean {

	private int occupation_id;
	private String occupation_value;
	
	public UserOccupationBean( int occupation_id, String occupation_value)
	{
		this.occupation_id = occupation_id;
		this.occupation_value = occupation_value;
	}

	public int getOccupation_id() {
		return occupation_id;
	}

	public void setOccupation_id(int occupation_id) {
		this.occupation_id = occupation_id;
	}

	public String getOccupation_value() {
		return occupation_value;
	}

	public void setOccupation_value(String occupation_value) {
		this.occupation_value = occupation_value;
	}
	
	
}
