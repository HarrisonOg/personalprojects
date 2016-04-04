package edu.csumb.scd.cs;
/*
*Author: Harrison Oglesby
*File: Instructor.java
*Date: 3/8/15
*
*Abstract:
*/



public class Instructor{
	private int instructorNum;
	private String name;
	private String phoneNum;
	private String email;
	
	
	public Instructor(){
		instructorNum = 000;
		phoneNum = "000-000-0000";
		email = "unknown";
	}
	
	public Instructor(int iNum, String nName, String nPhone, String nEmail){
		instructorNum = iNum;
		name = nName;
		phoneNum = nPhone;
		email = nEmail;
	}
	
	public int getInstructorNumber(){
		return instructorNum;
	}
	public String getName(){
		return name;
	}
	public String getPhoneNum(){
		return phoneNum;
	}
	public String getEmail(){
		return email;
	}
	
	public void setInstructorNum(int newNum){
		instructorNum = newNum;
	}
	public void setName(String newName){
		name = newName;
	}
	public void setPhoneNum(String newPhone){
		phoneNum = newPhone;
	}
	public void setEmail(String newEmail){
		email = newEmail;
	}
}
