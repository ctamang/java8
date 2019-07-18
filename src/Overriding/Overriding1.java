package Overriding;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
1... We can not reduce the visibility or scope of the inherited method from parent class.

2... Shape s = null;
	 s.draw(); 
	 public static void draw(){}
	 above code will not give us any error, because compiler will replace the s with the class name because the method is static.

3... we can not override static method although we can have the same method name as the parent in the child class with static 
	 keyword only then compile will allow ii. 
	 In this case no method overriding will happen because both methods are class level methods.
	 
4... We can not use static keyword with the child class method if the parent class does not have it. If we use it then compiler will
 	 give us an error. 
 	 Same goes for vice-versa. if parent class has static keyword then we can not override it. but we can have the same name method 
 	 with the static keyword.

5... Can overridden exception throw different checked exception then the one from the parent class?..
	 In case of checked exceptions the scope and visibility concept is reverted means --
	  	while overriding a method with exception we can compress the scope of the exception but we cannot widen it.
	  	for e.g.
	  	class Shape{
			 void draw() throws IOException
		    {
		        System.out.println("Shape");
		    }
		}
		 
		class Circle extends Shape{
		    public void draw() throws FileNotFoundException 
		    {
		        System.out.println("Circle");
		    }
		}
		in above example IOException is compressed to FileNotFoundException hence the program compiles fine. although the reverse of
		this will throw a compile time error.
		
		Important ::: We can change an exception from checked to unchecked but reverse is not possible
		
6... Can a return type be different in overridden method.
	 By using covariant return type we can achieve this. best example is wrapper classes. the restriction is only that the subclass
	 must have the subtype of the  return type that is used in the superclass.
	 Following are the examples of the correct implementation of this :
	  	Parent class - Number
	  	Child class - Integer, Byte , Short ,Long etc
	  	
	  	Parent class - Object
	  	Child class - Number, Integer, Byte , Short ,Long etc
	 Following are some not correct implementation : 
		Parent class - Integer
	  	Child class - Number, Long
	  	
	  	Parent class - String
	  	Child class - Number, Long

7. What are the rules to be followed while overriding a method?
	There are 5 main rules you should kept in mind while overriding a method. They are,
	a) Name of the method must be same as that of super class method.
	b) Return type of overridden method must be compatible with the method being overridden. i.e if
	   a method has primitive type as it’s return type then it must be overridden with primitive type only and if a method has
	   derived type as it’s return type then it must be overridden with same type or it’s sub class types.
	c) You must not reduce the visibility of a method while overriding.
	d) You must not change parameter list of a method while overriding.
	e) You can not increase the scope of exceptions while overriding a method with throws clause.
	
	*********************
	SOME MORE QUESTIONS
	*********************
1) What is method overriding?
Modifying a super class method in the sub class is called method overriding. Using method overriding, we can change super class method according to the requirements of sub class.

2) What are the rules to be followed while overriding a method?

There are 5 main rules you should kept in mind while overriding a method. They are,

a) Name of the method must be same as that of super class method.

b) Return type of overridden method must be compatible with the method being overridden. i.e if a method has primitive type as it’s return type then it must be overridden with primitive type only and if a method has derived type as it’s return type then it must be overridden with same type or it’s sub class types.

c) You must not reduce the visibility of a method while overriding.

d) You must not change parameter list of a method while overriding.

e) You can not increase the scope of exceptions while overriding a method with throws clause.

(Click here to see more about rules of method overriding)

3) Can we override static methods?

No, Static methods can not be overridden. If we try to override them they will be hidden in the sub class.

4) What happens if we change the arguments of overriding method?

If we change the arguments of overriding method, then that method will be treated as overloaded not overridden.

5) Can we override protected method of super class as public method in the sub class?

Yes. You can increase the visibility of overriding methods but can’t reduce it.

6) Can we change the return type of overriding method from Number type to Integer type?

Yes. You can change as Integer is a sub class of Number type.


7) Can we override a super class method without throws clause as a method with throws clause in the sub class?

Yes, but only with unchecked type of exceptions.

8) Can we change an exception of a method with throws clause from SQLException to NumberFormatException while overriding it?

Yes. Overridden method may throw SQLException or it’s sub class exception or any unchecked type of exceptions.

9) Can we change an exception of a method with throws clause from unchecked to checked while overriding it?

No. We can’t change an exception of a method with throws clause from unchecked to checked.

(Click here to see more about method overriding with throws clause)

10) How do you refer super class version of overridden method in the sub class?

Using super keyword, we can refer super class version of overridden method in the sub class.

11) Can we override private methods?

No question of overriding private methods. They are not at all inherited to sub class.

12) Can we remove throws clause of a method while overriding it?

Yes. You can remove throws clause of a method while overriding it.

13) Is it possible to override non-static methods as static?

No. You can’t override non-static methods as static.

14) Can we change an exception of a method with throws clause from checked to unchecked while overriding it?

Yes. We can change an exception from checked to unchecked but reverse is not possible.

15) Can we change the number of exceptions thrown by a method with throws clause while overriding it?

Yes, we can change. But, exceptions must be compatible with throws clause in the super class method.
	
 */ 
public class Overriding1 {

	public static void main(String [] args) throws IOException {

	}
}

class Parent{
    public String testMethod() throws IOException
    {
        System.out.println("Parent");
        return "";
    }
}
 
class Child extends Parent{
    public String testMethod() throws IOException, FileNotFoundException
    {
        System.out.println("Child");
        return "";
    }
}