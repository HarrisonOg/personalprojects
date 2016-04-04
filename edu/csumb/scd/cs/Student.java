package edu.csumb.scd.cs;
/*
*Author: Harrison Oglesby
*File: 
*Date:
*
*Abstract:
*/


public class Student{
	private int studentNum;
	private String name;
	private int courseNum;
	private double score;
	private String grade;
	
	
	public Student(){
		studentNum = 0;
		name = " ";
		courseNum = 0;
		score = 0.0;
		grade = "";
	}
	
	public Student(int nNum,String nName, int nCourse, double nScore, String nGrade){
		studentNum = nNum;
		name = nName;
		courseNum = nCourse;
		score = nScore;
		grade = nGrade;
	}
	
	//getters and setters
	public int getStudentNumber(){
		return studentNum;
	}
	public String getName(){
		return name;
	}
	public int getCourseNumber(){
		return courseNum;
	}
	public double getScore(){
		return score;
	}
	public String getGrade(){
		return grade;
	}
	
	public void setStudentNumber(int newNum){
		studentNum = newNum;
	}
	public void setName(String newName){
		name = newName;
	}
	public void setCourseNumber(int nCourse){
		courseNum = nCourse;
	}
	public void setScore(double nScore){
		score = nScore;
	}
	public void setGrade(String nGrade){
		grade = nGrade;
	}
}
