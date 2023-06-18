package customsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeByAge implements Comparator<Employee>{
	public int compare(Employee x,Employee y)
	{
		Integer i=x.getAge();//Auto Boxing
		Integer j=y.getAge();
		return i.compareTo(j);
		//return x.getAge()-y.getAge();
	}

}
