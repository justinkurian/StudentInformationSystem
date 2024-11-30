package com.studentapp;

public class Main {

	public static void main(String[] args) {
		System.out.println("****************Student Management System****************");
		
		Student s1;
		s1 = new Student("Justin Kurian",25, "S-01");
		s1.enrollCourse("Java");
		s1.enrollCourse("DSA");
		s1.enrollCourse("DevOps");
		s1.enrollCourse("C#");
		s1.printStudentInfo();
		
		Student s2 = new Student("Messi", 30, "S-10");
		s2.enrollCourse("DevOps");
		s2.printStudentInfo();
		
		Student s3 = new Student("Ronaldo", 32, "S-07");
		s3.enrollCourse("DSA");
		s3.printStudentInfo();
		

	}

}
