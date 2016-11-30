package cs320.lab1;

public class UserDetails {
	
	String username;
	String password;
	String emailID;
	
	public UserDetails (String username, String password, String emailID)
	{
		this.username = username;
		this.password = password;
		this.emailID = emailID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	

}
