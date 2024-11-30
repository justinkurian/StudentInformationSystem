package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	private static List<Student> studentList;

	public static void main(String[] args) {
		
		System.out.println("****************Student Management System****************");
		
		studentList = new ArrayList<Student>();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Student name...");
		String name=scanner.next();// if you want to read the input in string format, you need to use next()
		System.out.println("The name of the student is "+name);
		System.out.println("Enter Student age...");
		int age=scanner.nextInt();// if you want to read the input in int format, you need to use nextInt()
		System.out.println("The age of the student is "+age);
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
