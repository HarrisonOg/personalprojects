package edu.csumb.scd.cs;
/*
*Author: Harrison Oglesby
*File: Course.java
*Date: 3/8/15
*
*Abstract:  This class is for holding Course information
*/


public class Course{
	private int courseNumber;
	private String courseTitle;
	private int instructorNumber;
	private String location;
	private int numOfStudents;
	
	public Course(){
		courseNumber = 0;
		courseTitle = "";
		instructorNumber = 0;
		location = "";
		numOfStudents = 0;
	}
	
	public Course(int cNum, String cTitle, int iNum, String loc){
		courseNumber = cNum;
		courseTitle	= cTitle; 
		instructorNumber = iNum;
		location = loc;
		numOfStudents = 0;
	}
	
	public void updateLocation(String newLoc){
		location = newLoc;
	}
	
	
	//getters and setters
	public int getCourseNumber(){
		return courseNumber;
	}
	public String getCourseTitle(){
		return courseTitle;
	}
	public int getInstructorNumber(){
		return instructorNumber;
	}
	public String getLocation(){
		return location;
	}
	public int getNumOfStudents(){
		return numOfStudents;
	}
	
	public void setCourseNumber(int nCourse){
		courseNumber = nCourse;
	}
	public void setCourseTitle(String cTitle){
		courseTitle = cTitle;
	}
	public void setInstructorNumber(int nNumb){
		instructorNumber = nNumb;
	}
	public void clearStudents(){
		numOfStudents = 0;
	}
	public void addAnother(){
		numOfStudents++;
	}
	
	public void graduateAnother(){
		numOfStudents--;
	}
	
}
