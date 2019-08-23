package interviewQuestions;


/*
1. Can an abstract class have a constructor?
	Yes, an abstract class can have a constructor.

2. Is it possible to create abstract and final class in Java?
	An abstract class is incomplete and can only be instantiated by extending a concrete class and implementing all abstract methods, 
	while a final class is considered as complete and cannot be extended further. ... This is why making an abstract method final in 
	Java will result in a compile-time error.
	
3. Is it possible to have an abstract method in a final class?
	No ,abstract and final both should not give to a method.Abstract method should be overriden in the subclasses.But final methods 
	can't override.So these two rules are contradictory. No, because we have to provide the implementation to methods in subclasses. ...
	If it is declared as final, it cannot be overridden.	
	
4. Can abstract class implements interface in Java? does they require to implement all methods?
	Yes, abstract class can implement interface by using implements keyword. Since they are abstract, they don’t need to implement 
	all methods.

5. Can you create instance of abstract class?
	No, you can not create instance of abstract class in Java, they are incomplete.
	Even though, if your abstract class don’t contain any abstract method, you can not create instance of it.
	By making a class abstract, you told compiler that, it’s incomplete and should not be instantiated. Java compiler will throw 
	error, when a code tries to instantiate abstract class.

6. Is it necessary for abstract class to have abstract method?
	No, It is not mandatory for an abstract class to have any abstract method. We can make a class abstract in Java, by just using 
	abstract keyword in its declaration.	

7. Can we use “abstract” keyword with constructor, Instance Initialization Block and Static Initialization Block?
	No. Constructor, Static Initialization Block, Instance Initialization Block and variables can not be abstract.
	
8. We can’t instantiate an abstract class. Then why constructors are allowed in abstract class?
	It is because, we can’t create objects to abstract classes but we can create objects to their sub classes. From sub class 
	constructor, there will be an implicit call to super class constructor. That’s why abstract classes should have constructors. 
	Even if you don’t write constructor for your abstract class, compiler will keep default constructor.
	
10. Can we declare abstract methods as static?
	No, abstract methods can not be static. because static methods can't be overriden.	
	
11. Can a class contain an abstract class as a member?
	Yes, a class can have abstract class as it’s member.

11. Abstract classes can be nested. True or false?
	True. Abstract classes can be nested i.e an abstract class can have another abstract class as it’s member.	
	
12. Can we declare abstract methods as synchronized?
	No, abstract methods can not be declared as synchronized. But methods which override abstract methods can be declared as 
	synchronized.

13. Can abstract method declaration include throws clause?
	Yes. Abstract methods can be declared with throws clause.
 *
 *
 */

public class AbstractClass {
	 public static void main(String args[]) {  
		 Base b = new Derived(); 
	       b.fun(); 
	    } 
}

abstract class Base {
	
	static {
		System.out.println("in static block");
	}
	{
		System.out.println("in instance initialization block");
	}
	Base(){
		System.out.println("Base constructor");
	}
	final void fun() {
		System.out.println("fun called");
	}
}  
class Derived extends Base {
	
	static {
		System.out.println("is child's static block");
	}
	{
		System.out.println("in child's instance initialization block");
	}
	Derived(){
		System.out.println("derived Constructor");
	}
} 

