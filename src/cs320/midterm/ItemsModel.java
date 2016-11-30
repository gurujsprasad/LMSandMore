package cs320.midterm;

import java.util.Date;

public class ItemsModel {
	
	private String itemName;
	private String user;
	private int amount;
	private Date recievedDate;
	private String receivedFlag;
	
	
	public ItemsModel( String itemName, String user, int amount,Date recievedDate,String receivedFlag)
	{
		 this.itemName =itemName;
		 this.user = user;
		 this.amount = amount;
		 this.recievedDate = recievedDate;
		 this.receivedFlag = receivedFlag;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getRecievedDate() {
		return recievedDate;
	}
	public void setRecievedDate(Date recievedDate) {
		this.recievedDate = recievedDate;
	}
	public String getReceivedFlag() {
		return receivedFlag;
	}
	public void setReceivedFlag(String receivedFlag) {
		this.receivedFlag = receivedFlag;
	}
	

}
