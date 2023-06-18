package edbms;

import java.util.Scanner;

import customexception.InvalidChoiceException;


public class Solution {
	public static void main(String[] args) {
		System.out.println("=========WELCOME TO EMPLOYEE DATABASE================");
		System.out.println("-------------------");
		Scanner ip=new Scanner(System.in);
		
		//Upcasting to achieve the Abstration
		EmployeeManagementSystem ems=new EmployeeManagementSystemImpl();
		while(true)
		{
			//menu driven program
			System.out.println("1.addEmployee\n2.displayEmployee\n3.displayAllEmloyee\n4.removeEmployee\n5.removeAllEmployee");
			System.out.println("6.updateEmployee\n7.countEmployee\n8.sortEmployee\n9.findEmployeeWithHighestSalary\n10.findEMployeeWithLowestSalary");
			System.out.println("-----------------------");
			System.out.println("enter choice:");
			int choice=ip.nextInt();

			switch(choice)
			{
			
			case 1:
				ems.addEmployee();
				break;
			case 2:
				ems.displayEmployee();
				break;
			case 3:
				ems.displayAllEmployee();
				break;
			
			case 4:
				ems.removeEmployee();
				break;
			case 5:
				ems.removeAllEmployee();
			    break;
			case 6:
				ems.updateEmployee();
				break;
			case 7:
				ems.countEmployee();
				break;
			case 8:
				ems.sortEmployee();
				break;
			case 9:
				ems.findEmployeeWithHighestSalary();
				break;
			case 10:
				ems.findEmployeeWithLowestSalary();
				break;
			case 11:
				System.out.println("Thank you....!");
				System.exit(0);
			default:
				try {
				String message="Invalid Choice";
				throw new  InvalidChoiceException(message);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
						
				System.out.println("-------------------------------");
				
			}//ending switch loop
		}//ending while loop
		
	}// end main loop

}// end class 

























