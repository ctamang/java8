package InterviewQuestions;

/*
 
1.What is an interface in Java.
	Before Java 8 interfaces are pure abstract classes which allow us to define public static final variables and public abstract 
	methods(by default).
	In java 8 introduced static methods and default methods in interfaces. 
	Java 8 Interface Static and Default Methods
	We can develop interfaces by using "interface" keyword.  
	A class will implements all the methods in an interface.
 
2.What will happen if we define a concrete method in an interface?
	By default interface methods are abstract.
	if we declare any concrete method in an interface compile time error will come.
	Error:Abstract methods do not specify a body
 
3.Can we create non static variables in an interface?
	No.We can not create non static variables in an interface.
	If we try to create non static variables compile time error comes.
	By default members will be treated as public static final variables so it expects some value to be initialized.

4.What will happen if we not initialize variables in an interface.
	Compile time error will come because by default members will be treated as public static final variables so it expects some 
	value to be initialized.
	
5.Can we declare interface members as private or protected?
	No.	
	
7.When we need to use extends and implements?
	A class will implements an interface.
	A class will extends another class.
	An interface extends another interface.

6.Can we create object for an interface?
	NO. We can not create object for interface.
	We can create a variable for an interface

 7.Can we declare interface as final?
	No. Compile time error will come.
	Error: Illegal modifier for the interface Sample; only public & abstract are permitted
	interface%2Bfinal

8.Can we declare constructor  inside an interface?
	No. Interfaces does not allow constructors.
	The variables inside interfaces are static final variables means constants and we can not create object for interface so there 
	is no need of constructor in interface that is the reason interface doesn't allow us to create constructor.

9.What will happen if we are not implementing all the methods of an interface in class which implements an interface?
	A class which implements an interface should implement all the methods (abstract) otherwise compiler will throw an error.
	The type Example must implement the inherited abstract method JavaInterface.show() 
	If we declare class as abstract no need to implement methods. 
	No need of overriding default and static methods.

10.How can we access same variables defined in two interfaces implemented by a class?
	By Using corresponding interface.variable_name we can access variables of corresponding interfaces.

11.If  Same method is defined in two interfaces can we override this method in class implementing these interfaces.
	Yes implementing the method once is enough in class.
	A class cannot implement two interfaces that have methods with same name but different return type.
 
 
 ***********************************
 java8 interface
 ***********************************
Java 8 introduced two new methods in interface they are
	1.default methods
	2.static methods
	By this interfaces and abstract class are same but still having lot differences like abstract class can have a constructor etc will 
	discuss more before that we need to know about these Java 8 features of interfaces.
	Defaults methods are also called as defender methods can be implemented inside the interface
	Like normal class now with java 8 we can declare static methods in side a interface.
	Lets jump deep into Java 8 default and static methods 
 
1.Interface Default Methods in Java 8
	Before Java 8 in interfaces we were able to declare abstract methods only.
	If we declare a method without abstract that will be treated as abstract by default.
	As we know all methods in interfaces are by default abstract methods.
	These methods wont have body means implementations
	The class which is implementing this interface need to provide body / implementation for this abstract methods.
	Now with java 8 default methods we can add methods to interface without disturbing existing functionality.
	So instead of overriding now we can inherit these default methods from interfaces
	 
	Defaults methods are also  known as defender methods or virtual extension methods
	Default methods will help us to avoid utility classes.
	We can define utility methods inside the interface and use it in all classes which is implementing.
	One of the major reason to introduce this default methods in java 8 is to support lambda expressions in collections API and 
	to enhance.
	We can all these default methods by using interface name and also by using object of the class which is implementing
	https://stackoverflow.com/questions/55780860/how-do-java-8-default-methods-hеlp-with-lambdas
	
Can we override java 8 default method
	As we discussed above default methods in interfaces are implemented methods with bodies
	Yes we can override same method in class which is implementing this interface.
	Lets see one sample program how to override and what happens if we override

What happens if we implement two interfaces having same default methods
	Now lets see if a class implementing two interfaces which are having same default methods
	Whatever the implementation in the two interfaces defined if we implementing two interfaces which are having a default method in 
	both then compilation error will come if two methods have same signature.
	it works fine if two methods have same name with different arguments.
 
	If we implement two interfaces which are having same method with same parameters then compilation error will occur.
	Duplicate default methods named "defMethod" with the parameters () and () are inherited from the types A and B.
	If we define two methods with different type of parameters then we can work with both interfaces.
	
4. Multiple Interface Inheritance Rules
	Default interface methods are a pretty nice feature indeed, but with some caveats worth mentioning. Since Java allows classes to 
	implement multiple interfaces, it’s important to know what happens when a class implements several interfaces that define the 
	same default methods.
	To better understand this scenario, let’s define a new Alarm interface and refactor the Car class:
		
		public interface Alarm {
		    default String turnAlarmOn() {
		        return "Turning the alarm on.";
		    }
		    default String turnAlarmOff() {
		        return "Turning the alarm off.";
		    }
		}
		
	With this new interface defining its own set of default methods, the Car class would implement both Vehicle and Alarm:
		public class Car implements Vehicle, Alarm {
		    // ...
		}
	In this case, the code simply won’t compile, as there’s a conflict caused by multiple interface inheritance (a.k.a the Diamond 
	Problem). The Car class would inherit both sets of default methods. Which ones should be called then?
	To solve this ambiguity, we must explicitly provide an implementation for the methods:
		@Override
		public String turnAlarmOn() {
		    // custom implementation
		}
		@Override
		public String turnAlarmOff() {
		    // custom implementation
		}
		
	We can also have our class use the default methods of one of the interfaces.
	Let’s see an example that uses the default methods from the Vehicle interface:
		@Override
		public String turnAlarmOn() {
		    return Vehicle.super.turnAlarmOn();
		}
		 
		@Override
		public String turnAlarmOff() {
		    return Vehicle.super.turnAlarmOff();
		}
		
	Similarly, we can have the class use the default methods defined within the Alarm interface:
		@Override
		public String turnAlarmOn() {
		    return Alarm.super.turnAlarmOn();
		}
		 
		@Override
		public String turnAlarmOff() {
		    return Alarm.super.turnAlarmOff();
		}
		
	Furthermore, it’s even possible to make the Car class use both sets of default methods:
		@Override
		public String turnAlarmOn() {
		    return Vehicle.super.turnAlarmOn() + " " + Alarm.super.turnAlarmOn();
		}
		     
		@Override
		public String turnAlarmOff() {
		    return Vehicle.super.turnAlarmOff() + " " + Alarm.super.turnAlarmOff();
		}
 
******************************************
Interface Static Methods in Java 8
******************************************
	Another Java 8 interface method is static method.
	Now we can define static methods inside interface but we can not override these static methods.
	These static method will act as helper methods.
	These methods are the parts of interface not belongs to implementation class objects. 
	The idea behind static interface methods is to provide a simple mechanism that allows us to increase the degree of cohesion of a 
	design by putting together related methods in one single place without having to create an object.
	Pretty much the same can be done with abstract classes. The main difference lies in the fact that abstract classes can have 
	constructors, state, and behavior.
	Furthermore, static methods in interfaces make possible to group related utility methods, without having to create artificial 
	utility classes that are simply placeholders for static methods.
 
******************************************
 Java Functional Interfaces
******************************************
	An interface with exactly one abstract method is known as Functional Interface.
	A new annotation @FunctionalInterface has been introduced to mark an interface as Functional Interface. @FunctionalInterface 
	annotation is a facility to avoid accidental addition of abstract methods in the functional interfaces. It’s optional but good 
	practice to use it.
	Functional interfaces are long awaited and much sought out feature of Java 8 because it enables us to use lambda expressions to 
	instantiate them. A new package java.util.function with bunch of functional interfaces are added to provide target types for lambda 
	expressions and method references. 
 
 */

interface I1{
	void show();
	int sum();
	int a = 0;
	default void display() {
		System.out.println("display");
	}
	static void log() {
		System.out.println("log");
	}
	
}

interface I2{
	int a = 0;
	abstract void show();
	int sum();
	default void display(String s) {
		System.out.println("show me");
	}
	
	static void log() {
		System.out.println("int log");
	}
	
}

public class Interface1 implements I1,I2{

	@Override
	public void show() {
		System.out.println("show");
	}
	
	static void log() {
		System.out.println("overriden");
	}
	public static void main(String[] args) {
		Interface1 i = new Interface1();
		System.out.println(I1.a);
		Interface1.log();
		i.display();
		I1.log();
		I2.log();
		i.display("hello");
		i.show();
		
	}
	@Override
	public int sum() {
		return 0;
	}

}



