package comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
 
public class TestSorting {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "aTestName", "dLastName", 34);
        Employee e2 = new Employee(2, "nTestName", "pLastName", 30);
        Employee e3 = new Employee(3, "kTestName", "sLastName", 31);
        Employee e4 = new Employee(4, "dTestName", "zLastName", 25);
 
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(e2);
        employees.add(e3);
        employees.add(e1);
        employees.add(e4);
 
        // UnSorted List
        System.out.println("unsorted list");
        employees.forEach(item -> System.out.println(item));
 
        // Default Sorting by employee id
        Collections.sort(employees);
        System.out.println("sorted list using id");
        employees.forEach(item -> System.out.println(item));
        
        System.out.println("sorted list using firstName");
        
        Collections.sort(employees, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
        	
        });
        employees.forEach(item -> System.out.println(item));
        
        Collections.sort(employees, new AgeSorter());
        System.out.println("sorted list using Age");
        employees.forEach(item -> System.out.println(item));
        
      //using lambda
        Collections.sort(employees, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
        System.out.println("sorted list using lambda");
        employees.forEach(item -> System.out.println(item));
        
    }
}