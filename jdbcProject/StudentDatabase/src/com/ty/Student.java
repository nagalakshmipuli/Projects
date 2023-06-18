   package com.ty;

import java.util.Scanner;

public class Student {
	public static void main(String[] args) {
		StudentInterface si=new StudentImplementation();
		Scanner ip=new Scanner(System.in);
		while(true)
		{
			System.out.println("=========welcome to student database==========");
			System.out.println("1:addStudent\n2:deleteStudent\n3:updateStudent\n4:getStudentByMarks\n5:getAllStudent");
			System.out.println("enter choice:");
			int choice=ip.nextInt();
			switch(choice) {
			case 1:
				si.addStudent();
				System.out.println("Student data added successfully");
				break;
			case 2:
				si.deleteStudent();
				System.out.println("Student deleted successfully");
				break;
				
			case 3:
				si.updateStudent();
				System.out.println("Student uppdated added successfully");
				break;
			case 4:
				si.getStudentByMarks();
				System.out.println("get student data successfully");
				break;
			case 5:
				si.getAllStudent();
				System.out.println("get all student data successfully");
				break;
			default:
				System.out.println("Invalid choice");
			
			}
		}
	}

}
