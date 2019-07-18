package comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Java8Comparator {

	public static void main(String[] args) {
		  Employee e1 = new Employee(1, "aTestName", "dLastName", 34);
	        Employee e2 = new Employee(2, "nTestName", "pLastName", 30);
	        Employee e3 = new Employee(3, "kTestName", "sLastName", 31);
	        Employee e4 = new Employee(4, "dTestName", "zLastName", 25);
	        Employee e5 = new Employee(5, "dTestName", "cLastName", 45);
	        Employee e6 = new Employee(6, "dTestName", "aLastName", 18);
	 
	        List<Employee> employees = new ArrayList<Employee>();
	        employees.add(e2);
	        employees.add(e3);
	        employees.add(e1);
	        employees.add(e4);
	        employees.add(e5);
	        employees.add(e6);
	        
	        // UnSorted List
	        System.out.println("unsorted list");
	        employees.forEach(item -> System.out.println(item));
	 
	        // Sorting by firstName
	        employees.sort(Comparator.comparing(e -> e.getFirstName()));
	        // OR
	        employees.sort(Comparator.comparing(Employee::getFirstName));
	        System.out.println("sorted list using firstName");
	        employees.forEach(item -> System.out.println(item));
	        
	        //sorting by id
	        employees.sort(Comparator.comparing(e -> e.getId()));
	        //OR
	        employees.sort(Comparator.comparing(Employee::getId));
	        System.out.println("sorted list using id");
	        employees.forEach(item -> System.out.println(item));
	        
	        
	        //sorting in reverse order by firstName
	        employees.sort(Comparator.comparing(Employee::getFirstName).reversed());
	        System.out.println("sorted list using firstname reversed");
	        employees.forEach(item -> System.out.println(item));
	        
	        //sorting using more then one field
	        employees.sort(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName));
	        System.out.println("sorted list using firstname then lastname order by firstName");
	        employees.forEach(item -> System.out.println(item));
	        
	}
}
