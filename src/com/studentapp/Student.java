package com.studentapp;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class Student {

	private String name;
	private int age;
	private String studentId;
	private List<String> courses;

	public Student(String name, int age, String studentId) {
		super();
		if ((validateAge(age)) && (validateName(name)) && (validateStudentId(studentId))) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			courses = new ArrayList<String>();
		}
	}

	private boolean validateStudentId(String studentId) {
		String studentIdRegex = "S-\\d+$";
		Pattern studentIdPattern = Pattern.compile(studentIdRegex);
		Matcher studentIdMatcher = studentIdPattern.matcher(studentId);
		if (studentIdMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid studentID!!");
			return false;
		}

	}

	public void enrollCourse(String course) {
		if (validateCourseName(course)) {
		if (!courses.contains(course)) {
			courses.add(course);
			System.out.println("Student is enrolled to " + course + " successfully");
		} else {
			System.err.println("Student is already enrolled to the course " + course);
		}
		}
	}
	
	

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

	public void printStudentInfo() {
		System.out.println("========Student Information=======");
		System.out.println("Student Name: " + name);
		System.out.println("Student Age: " + age);
		System.out.println("Student ID:" + studentId);
		System.out.println("Enrolled to:" + courses);

	}

	// Validation methods

	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;

		} else {
			System.err.println("Invalid age!!");
			return false;
		}
	}

	public boolean validateCourseName(String course) {
		if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("DevOps")) {
			return true;
		} else {
			System.err.println("Invalid Course!!");
			return false;
		}
	}

	public boolean validateName(String name) {
		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Name!!");
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}
	
	

}
