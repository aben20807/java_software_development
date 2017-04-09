package main;

public class Email extends Document{

	private String sender;
	private String recipient;
	private String title;
	
	public String toString(){
		return "From: " + getSender() + "\nTo: " + getRecipient() + "\nTitle: " + getTitle() + "\n" + this.text;
	}
	
	public String getSender() {
		return sender;
	}
	
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getRecipient() {
		return recipient;
	}
	
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}
