package edu.csumb.scd.cs;
/*
*Author: Harrison Oglesby
*File: 
*Date:
*
*Abstract:
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class School{
	private String schoolName;
	private ArrayList<Student> students;
	private ArrayList<Course> courses;
	private ArrayList<Instructor> instructors;
	
	public School(){
		schoolName = "";
		students = new ArrayList<Student>();
		courses = new ArrayList<Course>();
		instructors = new ArrayList<Instructor>();
	}
	
	public School(String nName){
		schoolName = nName;
		students = new ArrayList<Student>();
		courses = new ArrayList<Course>();
		instructors = new ArrayList<Instructor>();
	}
	
	//Read Data
	public void readData(String fileLoc){
		System.out.println(fileLoc);
		try{
			File fil = new File(fileLoc);
			FileInputStream fis = new FileInputStream(fil);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			boolean status = br.ready();
			
			String first = br.readLine();
			char tmp = first.charAt(0);
			int ctr = (int)tmp - 48;
			System.out.println(ctr);
			String line = "";
			
			//instructors
			for(int i = 1; i <= ctr; i++){
				line = br.readLine();
				StringTokenizer sToken = new StringTokenizer(line, ",",false);
				//first token is instructor number
				String idStr = sToken.nextToken();
				int idTmp = Integer.parseInt(idStr);
				String nameStr = sToken.nextToken();
				String emailStr = sToken.nextToken();
				String phoneStr = sToken.nextToken();
				instructors.add(new Instructor(idTmp, nameStr, emailStr, phoneStr));
				//second token is name
				//third token is email
				//fourth token is phone number
			}
			
			String second = br.readLine();
			ctr = (int)second.charAt(0) - 48;

			for(int a = 1; a <= ctr; a++){
				line = br.readLine();
				StringTokenizer tToken = new StringTokenizer(line, ",",false);
				//course num, then title, then instructor id then location
				int crnT = Integer.parseInt(tToken.nextToken());
				String titleTmp = tToken.nextToken();
				int instrSTR = Integer.parseInt(tToken.nextToken());
				String locTmp = tToken.nextToken();
				//System.out.println(crnT + " " + titleTmp + " " + instrSTR + " " + locTmp);
				courses.add(new Course(crnT, titleTmp, instrSTR, locTmp));
			}
		
			String third = br.readLine();
			ctr = (int)third.charAt(0) - 48;
			
			for(int c = 1; c <= ctr; c++){
				line = br.readLine();
				StringTokenizer kToken = new StringTokenizer(line, ",",false);
				//id num, name, course num, score, grade
				int idNum = Integer.parseInt(kToken.nextToken());
				String bname = kToken.nextToken();
				int crn = Integer.parseInt(kToken.nextToken());
				double nScore = Double.parseDouble(kToken.nextToken());
				String agrade = kToken.nextToken();
				//System.out.println(idNum + " " + bname + " " + crn + " " +nScore+" "+agrade);
				students.add(new Student(idNum, bname, crn, nScore, agrade));
			}
			
			br.close();
			
		} catch (FileNotFoundException e){
			System.out.println("File not found");
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	
	//Add methods
	public void addCourse(int cNum, String cTitle, int iNum, String loc){
		boolean found = false;
		boolean realInstructor = false;
		for(int aCtr = 0; aCtr < instructors.size(); aCtr++){
			if(instructors.get(aCtr).getInstructorNumber() == iNum)
				realInstructor  = true;
		}
		if(!realInstructor){
			System.out.println("Non-existing Instructor Number");
		}
		else{
			for(int i = 0; i < courses.size(); i ++){
				if(courses.get(i).getCourseNumber() == cNum){
					System.out.println("Course number " + cNum + " is already in use.");
					found = true;
				}
			}
			if(!found){
				Course course2 = new Course(cNum, cTitle, iNum, loc);
				courses.add(course2);
				System.out.println("Added Course");
			}
		}
	}
	
	public void addInstructor(int iNum, String nName, String nPhone, String nEmail){
		boolean found = false;
		for(int k = 0; k < instructors.size(); k++){
			if(instructors.get(k).getInstructorNumber() == iNum){
				System.out.println("Instructor number " + iNum + " is already in use.");
				found = true;
			}
		}
		if(!found){
			Instructor instructor1 = new Instructor(iNum,  nName, nPhone, nEmail);
			instructors.add(instructor1);
		}
	}
	
	public void addStudent(int nNum,String nName, int nCourse, double nScore, String nGrade){
		boolean found = false;
		for(int g = 0; g < students.size(); g++){
			if(students.get(g).getStudentNumber() == nNum){
				if(!students.get(g).getName().equals(nName)){
					System.out.println("Student number " + nNum + " is already in use.");
					found = true;
				}
			}
		}
		if(!found){
			Student student1 = new Student(nNum, nName, nCourse, nScore, nGrade);
			students.add(student1);
			
			for(int a = 0; a < courses.size(); a++){
				if(courses.get(a).getCourseNumber() == nCourse){
					courses.get(a).addAnother();
				}
			}
		}
	}
	
	//Get course
	public Course getCourse(int num){
		int tempIndex = 0;
		for(int t = 0; t < courses.size(); t++){
			if(courses.get(t).getCourseNumber() == num){
				tempIndex = t;
			}
		}
		if(courses.size() == 0){
			return null;
		}
		else{
			return courses.get(tempIndex);
		}
	}
	
	
	//info methods
	
	public void studentInfo(int findID){
		ArrayList<Integer> ar1 = new ArrayList<Integer>();
		for(int z = 0; z < students.size(); z++){
			if(students.get(z).getStudentNumber() == findID){
				ar1.add(z);
			}
		}
		int tmpIndex;
		tmpIndex = ar1.get(0);
		System.out.println("Student Number: " + students.get(tmpIndex).getStudentNumber());
		System.out.println("Name: " + students.get(tmpIndex).getName());
		for(int ctr = 0; ctr < ar1.size(); ctr++){
				Student temp = new Student();
				tmpIndex = ar1.get(ctr);
				temp = students.get(tmpIndex);
				System.out.print("\t"+temp.getCourseNumber() + ": " + temp.getScore());
				System.out.println("  (" + temp.getGrade() + ")"); 
		}
	}
	
	public void courseInfo(){
		System.out.println("Number of courses: " + courses.size());
		for(int i = 0; i  < courses.size(); i++){
			System.out.print(courses.get(i).getCourseNumber() + ": ");
			System.out.println(courses.get(i).getNumOfStudents() + " enrolled");
			
		}
	}
	
	public void courseInfo(int coNum){
		int tempCIndex = 0, tempIIndex = 0;
		for(int j = 0; j < courses.size(); j++){
			if(courses.get(j).getCourseNumber() == coNum){
				tempCIndex = j;
			}
		}
		for(int p = 0; p < instructors.size(); p++){
			if(instructors.get(p).getInstructorNumber() == courses.get(tempCIndex).getInstructorNumber()){
				tempIIndex = p;
			}
		}
		System.out.println("Course Number: " + coNum);
		System.out.println("Instructor: " + instructors.get(tempIIndex).getName());
		System.out.println("Course Title: " + courses.get(tempCIndex).getCourseTitle());
		System.out.println("Room: " + courses.get(tempCIndex).getLocation());
		System.out.println("Enrolled Students:");
		
		for(int u = 0; u < students.size(); u++){
			if(students.get(u).getCourseNumber() == coNum){
				System.out.println("	" + students.get(u).getName() + ": "
									+ students.get(u).getScore() + " ("
									+ students.get(u).getGrade() + ")" );
			}
		}
	}
	
	public void schoolInfo(){
		System.out.println("School Name: " + schoolName);
		System.out.println("Instructor information");
		for(int a = 0; a < instructors.size(); a++){
			System.out.println("	" + instructors.get(a).getName());
		}
		System.out.println("Course Information");
		for(int b = 0; b < courses.size(); b++){
			System.out.println("	" + courses.get(b).getCourseTitle());
		}
		System.out.println("Student Information");
		for(int c = 0; c < students.size(); c++){
			int tempCNum = students.get(c).getCourseNumber();
			String temp = "";
			for(int d = 0; d < courses.size(); d++){
				if(courses.get(d).getCourseNumber() == tempCNum){
					temp = courses.get(d).getCourseTitle();
				}
			}
			System.out.println("	" + students.get(c).getName() + ":"
							+ temp);
		}
	}
	
	public void graduateStudent(int gradID){
		int tmpCN;
		int daSize = students.size();
		for(int lpr = 0; lpr < daSize; lpr++){
			if(students.get(lpr).getStudentNumber() == gradID){
				tmpCN = students.get(lpr).getCourseNumber();
				System.out.println("Found: " + students.get(lpr).getName());
				students.remove(lpr);
				daSize--;
				getCourse(tmpCN).graduateAnother();
				
			}
		}
	}
	
	//deletes the course if the course has no enrolled students
	public void deleteCourse(int couNum){
		for(int e = 0; e < courses.size(); e++){
			if(courses.get(e).getCourseNumber() == couNum){
				if(courses.get(e).getNumOfStudents() == 0){
					System.out.println(courses.get(e).getCourseNumber());
					courses.remove(e);
					System.out.println("Deleted course");
				}
			}
		}
	}



}
