package edbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.EmployeeNotFoundException;
import customexception.InvalidChoiceException;
import customexception.EmployeeNotFoundException;
import customsorting.SortEmployeeByAge;
import customsorting.SortEmployeeById;
import customsorting.SortEmployeeByName;
import customsorting.SortEmployeeBySalary;




public class EmployeeManagementSystemImpl implements EmployeeManagementSystem{
	Scanner ip=new Scanner(System.in);


	Map<String,Employee> db=new LinkedHashMap<String,Employee>();
	@Override
	public void addEmployee()
	{
		//Accepting age
		System.out.println("enter age:");
		int age=ip.nextInt();

		//Accepting name
		System.out.println("enter name");
		String name=ip.next();

		//Accepting marks
		System.out.println("enter salary:");
		double salary=ip.nextDouble();

		//creating student instance/object
		Employee emp=new Employee(name,age,salary);

		//adding entry inside the db(map)
		db.put(emp.getId(), emp);
		System.out.println("student record inserted Successfully!!!");
		System.out.println("id:"+emp.getId());


	}
	@Override
	public void displayEmployee()
	{
		//Accepting Employee ID--->jsp101, Jsp101, JSP101
		System.out.println("Enter Employee Id:");
		String id=ip.next();//String id=ip.next().toUpperCase();
		id=id.toUpperCase();

		//checking if the id is present or not -->(id==key)
		if(db.containsKey(id))
		{
			System.out.println("Employee Record Found!");
			System.out.println("Employee details as follows:");
			System.out.println("------------------------------");
			//get the Employee Object-->get()-->getAge(),getname()..........
			Employee emp=db.get(id);//getting Employee object based on id
			System.out.println("ID: "+emp.getId());
			System.out.println("Age: "+emp.getAge());
			System.out.println("Name: "+emp.getName());
			System.out.println("Marks: "+emp.getSalary());
			//printing reference variable as toSting() is overriden
			//System.out.println(emp);
		}
		else
		{
			try
			{
				String message="Student with Id "+id+" is not found!!";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}

	}
	@Override
	public void displayAllEmployee()
	{
		if(!db.isEmpty())//checking if database(db) is empty
		{
			System.out.println("Employeet Records are as follow:");
			System.out.println("------------------------------");
			Set<String> keys=db.keySet();//JSP101,JSP102,JSP103................
			for(String key:keys)
			{
				Employee emp=db.get(key);//getting Employee Objects
				System.out.println(emp);//toString() is overridden

			}
		}
		else
		{
			try
			{
				String message="No Employee Records to Display";
				throw new EmployeeNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage() );
			}
		}
	}
	@Override
	public void removeEmployee()
	{
		//Accepting Employee id
		System.out.println("Enter Employee id:");
		String id=ip.next();
		//conveting upper case
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println("Employee Id found");
			System.out.println(db.get(id));//printing student object
			db.remove(id);//removing the entry(key&value)
			System.out.println("Employee Record Deleted Successfully");

		}
		else
		{
			try
			{
				String message="Employeewith id "+id +" is not found!";
				throw new EmployeeNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeAllEmployee()
	{
		if(!db.isEmpty())
		{
			System.out.println("no of Employee Record "+db.size());
			db.clear();
			System.out.println("All Employee Records Deleted Successfully");
		}
		else
		{
			try
			{
				String message="No Employee Records to Delete";
				throw new EmployeeNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void updateEmployee()
	{
		System.out.println("Enter Employee Id:");
		String id=ip.next().toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println("Employee REcord Found");
			Employee emp=db.get(id);//getting Employee objects
			System.out.println("1.Update Age\n2.Update Name\n3.Update salary\nEnter Choice:");
			int choice=ip.nextInt();

			switch(choice)
			{
			case 1:
				System.out.println("enter age:");
				int age=ip.nextInt();
				emp.setAge(age);//emp.setAge(ip.nextInt());
				System.out.println("Employee Age updated successfully");
				break;
			case 2:
				System.out.println("Enter Name ");
				String name=ip.next();
				emp.setName(name);//emp.setName(ip.next());
				System.out.println("Employee Name Updated successfully");
				break;
			case 3:
				System.out.println("Enter Marks:");
				double salary=ip.nextDouble();
				emp.setSalary(salary);//std.setMarks(ip.nextInt());
				System.out.println("Employee salary Updated successfully");
				break;
			default:
				try
				{
					String message="invalid choice ,please enter valid choice";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		else
		{
			try
			{
				String message="Employee with "+id+" is not found!";
				throw new EmployeeNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}
	@Override
	public void countEmployee()
	{
		System.out.println("No of Employee records:"+db.size());
	}
	@Override
	public void sortEmployee()
	{
		/**                                Documentation comment
		 * we cannot sort Map based on values , therefore we are getting the values from Map & storing it inside list
		 * so that we can sort list using -> Collections.sort(list,sorting logic object);
		 */
		//reference of List & object of ArrayList storing Student Objects
		List<Employee>list=new ArrayList<Employee>();

		//Converting Map into set, which stores keys(Id)
		Set<String>keys=db.keySet();

		//traversing keys(Id)
		for(String key:keys)
		{
			//Storing value (Student Object) & adding it into List
			list.add(db.get(key));
		}
		System.out.println("1.Sort Employee By Id\n2.Sort Employee By Age\n3.Sort Employee By Name\n4.Sort Employee By Marks\nEnter Choice");
		int choice=ip.nextInt();

		switch(choice)
		{
		case 1:
			Collections.sort(list,new SortEmployeeById());
			for(Employee e:list)
			{
				System.out.println(e);
			}
			break;
		case 2:
			Collections.sort(list,new SortEmployeeByAge());
			for(Employee s:list)
			{
				System.out.println(s);
			}
			break;
		case 3:
			Collections.sort(list ,new SortEmployeeByName());
			for(Employee s:list)
			{
				System.out.println(s);
			}
			break;
		case 4:
			Collections.sort(list,new SortEmployeeBySalary());
			for(Employee s:list)
			{
				System.out.println(s);
			}
			break;
		default:
			try
			{
				String message="invalid choice ,please enter valid choice";
				throw new InvalidChoiceException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

		}

	}
	@Override
	public void findEmployeeWithHighestSalary()
	{
		List<Employee>list=new ArrayList<Employee>();
		Set<String>keys=db.keySet();
		for(String key:keys)
		{
			list.add(db.get(key));//adding Employee objects from map into list
		}
		Collections.sort(list,new SortEmployeeBySalary());
		System.out.println("Employee with highest marks:");
		System.out.println(list.get(list.size()-1));

	}
	@Override
	public void findEmployeeWithLowestSalary() {
		List<Employee>list=new ArrayList<Employee>();
		Set<String>keys=db.keySet();
		for(String key:keys)
		{
			list.add(db.get(key));//adding Employee objects from map into list
		}
		Collections.sort(list,new SortEmployeeBySalary());
		System.out.println("Employee with lowest marks:");
		System.out.println(list.get(0));
		
	}
	
	



}
