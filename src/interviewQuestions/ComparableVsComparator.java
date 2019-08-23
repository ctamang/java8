package interviewQuestions;


/*

*********************
Java Comparable
**********************
Java provides Comparable interface which should be implemented by any custom class if we want to use Arrays or Collections sorting 
methods.
The Comparable interface has compareTo(T obj) method which is used by sorting methods, you can check any Wrapper, String or Date 
class to confirm this. We should override this method in such a way that it returns a negative integer, zero, or a positive integer 
if “this” object is less than, equal to, or greater than the object passed as an argument.
But, in most real-life scenarios, we want sorting based on different parameters. For example, as a CEO, I would like to sort the 
employees based on Salary, an HR would like to sort them based on age. This is the situation where we need to use Java Comparator 
interface because Comparable.compareTo(Object o) method implementation can provide default sorting and we can’t change it dynamically. 
Whereas with Comparator, we can define multiple methods with different ways of sorting and then chose the sorting method based on our 
requirements.

*********************
Java Comparator
**********************
Comparator interface compare(Object o1, Object o2) method need to be implemented that takes two Object argument, it should be 
implemented in such a way that it returns negative int if the first argument is less than the second one and returns zero if they 
are equal and positive int if the first argument is greater than the second one.

Comparable and Comparator interfaces use Generics for compile-time type checking.

*************************
Comparable vs Comparator
*************************
1. Comparable interface can be used to provide single way of sorting whereas Comparator interface is used to provide different ways
   of sorting.
2. For using Comparable, Class needs to implement it whereas for using Comparator we don’t need to make any change in the class.
3. Comparable interface is in java.lang package whereas Comparator interface is present in java.util package.
4. We don’t need to make any code changes at client side for using Comparable, Arrays.sort() or Collection.sort() methods 
   automatically uses the compareTo() method of the class. For Comparator, client needs to provide the Comparator class to use in 
   compare() method.
5. Comparable is meant for objects with natural ordering which means the object itself must know how it is to be ordered. For example
   Roll Numbers of students. Whereas, Comparator interface sorting is done through a separate class.
6. Logically, Comparable interface compares “this” reference with the object specified and Comparator in Java compares two different 
   class objects provided.
7. If any class implements Comparable interface in Java then collection of that object either List or Array can be sorted 
   automatically by using Collections.sort() or Arrays.sort() method and objects will be sorted based on there natural order defined 
   by CompareTo method.
8. there can be only one comparison implemented using comparable. On the other hand, you can write as many custom comparators as you 
   want for a given type, all using different interpretations of what sorting means.


*
*
*
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableVsComparator {

	public static void main(String [] args) {
		
		Student s1 = new Student(1,"chandan", "tamang","tamang@gmail.com");
		Student s5 = new Student(1,"chandan", "moktan","tamang@gmail.com");
		Student s2 = new Student(5,"deepak", "rawat", "deepak@gmail.com");
		Student s6 = new Student(5,"deepak", "negi", "deepak@gmail.com");

		Student s3 = new Student(3,"pankaj", "goswami", "pankaj@gmail.com");
		Student s4 = new Student(2,"nisarg", "patil", "patil@gmail.com");
		
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		studentList.add(s5);
		studentList.add(s6);
		
		//Collections.sort(studentList);
		
		studentList.sort(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.firstName.compareTo(o2.firstName);
			}
			
		});
		//System.out.println(studentList);
		
		
		Collections.sort(studentList, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.lastName.compareTo(o2.lastName);
			}
			
		});
		
		Collections.sort(studentList, new EmailSorter());
		
		
		studentList.sort(Comparator.comparing(Student::getFirstName));
		studentList.sort(Comparator.comparing(i -> i.getFirstName()));
		
		studentList.sort(Comparator.comparing(Student::getFirstName).thenComparing(Student::getLastName));
		
		studentList.sort(Comparator.comparing(Student::getFirstName).reversed());
		
		System.out.println(studentList);
		
	}
}


class Student implements Comparable<Student>{
	
	int id;
	String firstName;
	String lastName;
	String email;
	public Student(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(Student o) {
		if(this.id < o.id)
			return -1;
		if(this.id > o.id) 
			return 1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]\n";
	}

}

class EmailSorter implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return  o1.email.compareTo(o2.email);
	}
	
}