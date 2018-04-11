package main.com.objectLayer;

public class Person {

	private String firstName;
	private String lastName;
	private int userId;
	private String email;
	
	public Person(){
		
	}
	
	public Person(String firstName, String lastName, int userId, String email){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public int getuserId(){
		return userId;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
}
