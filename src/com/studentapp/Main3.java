package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main3 {

	private static List<Student> studentList;

	public static void main(String[] args) {
		
		System.out.println("****************Student Management System****************");
		
		studentList = new ArrayList<Student>();
		
		Student s1;
		s1 = new Student("Justin Kurian", 25, "S-01");
		s1.enrollCourse("Java");
		s1.enrollCourse("DSA");
		s1.enrollCourse("DevOps");
		s1.enrollCourse("C#");

		Student s2 = new Student("Messi", 30, "S-10");
		s2.enrollCourse("DevOps");

		Student s3 = new Student("Ronaldo", 32, "S-07");
		s3.enrollCourse("DSA");
		
		Student s4 = new Student("Aguero", 31, "S-11");
		s4.enrollCourse("DSA");

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		
		Student result = findStudentById("S-07");
		System.out.println("Result" + result);
		sortByName();
	}
	
	
	private static void sortByName() {
		Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
				
// new Comparator<Student>() {
//			
//			@Override
//			public int compare(Student o1, Student o2) {
//				
//				return o1.getName().compareTo(o2.getName());
//			}
//		};
				
		Collections.sort(studentList, studentNameComparator);
		System.out.println(studentList);
		
	}


	public static Student findStudentById(String studentId) {
		Student result = null;
		try {
		result = studentList.stream()
				.filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No data found"));
		}
		catch(RuntimeException e) {
			System.err.println("Student with ID " +studentId+ " not found");
		}
		return result;
	}
	
	

}
