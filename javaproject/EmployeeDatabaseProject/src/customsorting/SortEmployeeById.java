package customsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeById implements Comparator<Employee>{
	public int compare(Employee x,Employee y)
	{
		 String i=x.getId();
		 String j=x.getId();
		 return i.compareTo(j);
		 //return x.getId().compareTo(y.getId());
	}

}
