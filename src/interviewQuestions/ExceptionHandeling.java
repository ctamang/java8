	package interviewQuestions;
	
/*
1) What is an exception?
	Exception is an abnormal condition which occurs during the execution of a program and disrupts normal flow of the program. This exception must be handled properly. If it is not handled, program will be terminated abruptly.
2) How the exceptions are handled in java? OR Explain exception handling mechanism in java?
	Exceptions in java are handled using try, catch and finally blocks.
	try block : The code or set of statements which are to be monitored for exception are kept in this block.
	catch block : This block catches the exceptions occurred in the try block.
	finally block : This block is always executed whether exception is occurred in the try block or not and occurred exception is caught in the catch block or not.
3) What is the difference between error and exception in java?
	Errors are mainly caused by the environment in which an application is running. For example, OutOfMemoryError happens when JVM runs out of memory. Where as exceptions are mainly caused by the application itself. For example, NullPointerException occurs when an application tries to access null object.
4) Can we keep other statements in between try, catch and finally blocks?
	No. We shouldn’t write any other statements in between try, catch and finally blocks. They form a one unit.
	try
	{
	    // Statements to be monitored for exceptions
	}
	//You can't keep statements here
	catch(Exception ex)
	{
	    //Cathcing the exceptions here
	}
	//You can't keep statements here
	finally
	{
	    // This block is always executed
	}
5) Can we write only try block without catch and finally blocks?
	No, It shows compilation error. The try block must be followed by either catch or finally block. You can remove either catch block or finally block but not both.
6) There are three statements in a try block – statement1, statement2 and statement3. After that there is a catch block to catch the exceptions occurred in the try block. Assume that exception has occurred in statement2. Does statement3 get executed or not?
	No. Once a try block throws an exception, remaining statements will not be executed. control comes directly to catch block.
7) What is unreachable catch block error?
	When you are keeping multiple catch blocks, the order of catch blocks must be from most specific to most general ones. i.e sub classes of Exception must come first and super classes later. If you keep super classes first and sub classes later, compiler will show unreachable catch block error.
	public class ExceptionHandling
	{
	    public static void main(String[] args)
	    {
	        try
	        {
	            int i = Integer.parseInt("abc");   //This statement throws NumberFormatException
	        }
	  
	        catch(Exception ex)
	        {
	            System.out.println("This block handles all exception types");
	        }
	  
	        catch(NumberFormatException ex)
	        {
	            //Compile time error
	            //This block becomes unreachable as
	            //exception is already caught by above catch block
	        }
	    }
	}

9) What are run time exceptions in java. Give example?
	The exceptions which occur at run time are called as run time exceptions. These exceptions are unknown to compiler. All sub classes of java.lang.RunTimeException and java.lang.Error are run time exceptions. These exceptions are unchecked type of exceptions. For example, NumberFormatException, NullPointerException, ClassCastException, ArrayIndexOutOfBoundException, StackOverflowError etc.
10) What is OutOfMemoryError in java?
	OutOfMemoryError is the sub class of java.lang.Error which occurs when JVM runs out of memory.
11) what are checked and unchecked exceptions in java?
	Checked exceptions are the exceptions which are known to compiler. These exceptions are checked at compile time only. Hence the name checked exceptions. These exceptions are also called compile time exceptions. Because, these exceptions will be known during compile time.
	Unchecked exceptions are those exceptions which are not at all known to compiler. These exceptions occur only at run time. These exceptions are also called as run time exceptions. All sub classes of java.lang.RunTimeException and java.lang.Error are unchecked exceptions.

	Checked Exceptions									Unchecked Exceptions
  1.They are known at compile time.						They are known at run time.
  2.They are checked at compile time.					They are not checked at compile time. Because they occur only at run time.
  3.	These are compile time exceptions.					These are run time exceptions.
  4.	If  these exceptions are not handled properly 		If these exceptions are not handled properly, they don’t give compile time error. But application will be terminated prematurely at run time.
	in the application, they give compile time error.		
  5.All sub classes of java.lang.Exception Class 			All sub classes of RunTimeException and sub classes of java.lang.Error are unchecked exceptions.
	except sub classes of RunTimeException are 
	checked exceptions.	

12) What is the difference between ClassNotFoundException and NoClassDefFoundError in java?
	ClassNotFoundException	NoClassDefFoundError
  1.It is an exception. It is of type java.lang.Exception.		It is an error. It is of type java.lang.Error.
  2.It occurs when an application tries to load a class at 		It occurs when java runtime system doesn’t find a class definition, which is present at compile time, but missing at run time.
  	run time which is not updated in the classpath.	
  3.It is thrown by the application itself. It is thrown 			It is thrown by the Java Runtime System.
  	by the methods like Class.forName(), loadClass() and 
  	findSystemClass().	
  4.It occurs when classpath is not updated with required 		It occurs when required class definition is missing at run time.
  	JAR files.	
  	
 13) Can we keep the statements after finally block If the control is returning from the finally block itself?
	No, it gives unreachable code error. Because, control is returning from the finally block itself. Compiler will not see the statements after it. That’s why it shows unreachable code error.

14) Does finally block get executed If either try or catch blocks are returning the control?
	Yes, finally block will be always executed no matter whether try or catch blocks are returning the control or not.
	
15) Can we throw an exception manually? If yes, how?
	Yes, we can throw an exception manually using throw keyword. Syntax for throwing an exception manually is
	throw InstanceOfThrowableType;
	Below example shows how to use throw keyword to throw an exception manually.
	try
	{
	    NumberFormatException ex = new NumberFormatException();    //Creating an object to NumberFormatException explicitly
	    throw ex;        //throwing NumberFormatException object explicitly using throw keyword
	}
	catch(NumberFormatException ex)
	{
	    System.out.println("explicitly thrown NumberFormatException object will be caught here");
	}	 
	 
 
16) Throwing An Exception :
	We all know that Throwable class is super class for all types of errors and exceptions. An object to this Throwable class or it’s sub classes can be created in
	two ways. First one is using an argument of catch block. In this way, Throwable object or object to it’s sub classes is implicitly created and thrown by java 
	run time system. Second one is using new operator. In this way, Throwable object or object to it’s sub classes is explicitly created and thrown by the code.
	An object to Throwable or to it’s sub classes can be explicitly created and thrown by using throw keyword. The syntax for using throw keyword is,
	throw InstanceOfThrowableType;
	where, InstanceOfThrowableType must be an object of type Throwable or subclass of Throwable.
	Such explicitly thrown exception must be handled some where in the program, otherwise program will be terminated.
	For example,
	public class ExceptionHandling
	{
		public static void main(String[] args)
		{
			methodWithThrow();
		}
	
		static void methodWithThrow()
		{
			try
			{
				NumberFormatException ex = new NumberFormatException();    //Creating an object to NumberFormatException explicitly
	
				throw ex;        //throwing NumberFormatException object explicitly using throw keyword
			}
			catch(NumberFormatException ex)
			{
				System.out.println("explicitly thrown NumberFormatException object will be caught here");
			}
		}
	}
	It is not compulsory that explicitly thrown exception must be handled by immediately following try-catch block. It can be handled by any one of it’s enclosing
	try-catch blocks.
	public class ExceptionHandling
	{
		public static void main(String[] args)
		{
			try
			{
				methodWithThrow();
			}
			catch(NumberFormatException ex)
			{
				System.out.println("NumberFormatException object thrown in methodWithThrow() method will be handled here");
			}
		}
	
		static void methodWithThrow()
		{
			try
			{
				NumberFormatException ex = new NumberFormatException("This is an object of NumberFormatException");
	
				throw ex;        //throwing NumberFormatException object explicitly using throw keyword
			}
			catch(ArithmeticException ex)
			{
				System.out.println("Explicitly thrown NumberFormatException object will not be caught here");
			}
		}
	}
	Re-throwing An Exception :
	We all know that exceptions occurred in the try block are caught in catch block. Thus caught exceptions can be re-thrown using throw keyword. Re-thrown exception
	must be handled some where in the program, otherwise program will terminate abruptly. For example,
	public class ExceptionHandling
	{
		public static void main(String[] args)
		{
			try
			{
				methodWithThrow();
			}
			catch(NullPointerException ex)
			{
				System.out.println("NullPointerException Re-thrown in methodWithThrow() method will be handled here");
			}
		}
	
		static void methodWithThrow()
		{
			try
			{
				String s = null;
				System.out.println(s.length());   //This statement throws NullPointerException
			}
			catch(NullPointerException ex)
			{
				System.out.println("NullPointerException is caught here");
	
				throw ex;     //Re-throwing NullPointerException
			}
		}
	}	
	
18) Why it is always recommended that clean up operations like closing the DB resources to keep inside a finally block?
	Because finally block is always executed whether exceptions are raised in the try block or not and raised exceptions are caught in the catch block or not. By 
	keeping the clean up operations in finally block, you will ensure that those operations will be always executed irrespective of whether exception is occurred or not.

20) How do you create customized exceptions in java?
 	In java, we can define our own exception classes as per our requirements. These exceptions are called user defined exceptions in java OR Customized exceptions. User defined exceptions must extend any one of the classes in the hierarchy of exceptions.
		Let’s see how to use user defined exceptions in java.
		Consider the following example. This example throws an exception when user enters negative age.
		public class ExceptionHandling
		{
		    public static void main(String[] args)
		    {
		          Scanner sc = new Scanner(System.in);  //Declaring Scanner variable to take input from user
		 
		          System.out.println("Enter Your Age");
		 
		          int age = sc.nextInt();         //Taking input from user
		 
		          try
		          {
		              if(age < 0)
		              {
		                  throw new Exception();    //throws an Exception if age is negative
		              }
		          }
		          catch(Exception ex)
		          {
		              System.out.println(ex);     //Prints exception description
		          }
		    }
		}
		When user enters negative value in the above example, it throws an exception and prints exception description which user may not understand. So, Let’s make this program more user friendly. Modify above example so that user can understand why the exception has occurred. To do this, create one sub class to Exception class and override toString() method.
		//Defining Our own exception by extending Exception class
		class AgeIsNegativeException extends Exception
		{
		    String errorMessage;
		 
		    public AgeIsNegativeException(String errorMessage)
		    {
		        this.errorMessage = errorMessage;
		    }
		 
		    //Modifying toString() method to display customized error message
		 
		    @Override
		    public String toString()
		    {
		        return errorMessage;
		    }
		}
		Above defined exception is called user defined exception or customized exception. Now throw this customized exception when user enters negative value.
		public class ExceptionHandling
		{
		    public static void main(String[] args)
		    {
		          Scanner sc = new Scanner(System.in);  //Declaring Scanner variable to take input from user
		 
		          System.out.println("Enter Your Age");
		 
		          int age = sc.nextInt();         //Taking input from user
		 
		          try
		          {
		              if(age < 0)
		              {
		                  throw new AgeIsNegativeException("Age can not be negative");    //throws AgeIsNegativeException if age is negative
		              }
		          }
		          catch(AgeIsNegativeException ex)
		          {
		              System.out.println(ex);    //Output : Age can not be negative
		          }
		    }
		}
		Now, this prints “Age can not be negative” when user enters a negative value. This makes the user understand easily why the error has occurred.

21) What is ClassCastException in java?
	ClassCastException is a RunTimeException which occurs when JVM unable to cast an object of one type to another type.
			 
22) What is the difference between throw, throws and throwable in java?
	This is another most confusing java interview question asked to java freshers. Interviewer ask this type of questions to confuse the candidate because all three spell similar. But, all three serve different purpose in java. In this article, we will see the differences between throw, throws and Throwable in java.
	throw In Java :
		throw is a keyword in java which is used to throw an exception manually. Using throw keyword, you can throw an exception from any method or block. But, that exception must be of type java.lang.Throwable class or it’s sub classes. Below example shows how to throw an exception using throw keyword.
		class ThrowAndThrowsExample
		{
		    void method() throws Exception
		    {
		        Exception e = new Exception();
		 
		        throw e;            //throwing an exception using 'throw'
		    }
		}
	throws In Java :
		throws is also a keyword in java which is used in the method signature to indicate that this method may throw mentioned exceptions. The caller to such methods must handle the mentioned exceptions either using try-catch blocks or using throws keyword. Below is the syntax for using throws keyword.
		return_type method_name(parameter_list) throws exception_list
		{
		     //some statements
		}
		
		Below is the example which shows how to use throws keyword.
		class ThrowsExample
		{
		    void methodOne() throws SQLException
		    {
		        //This method may throw SQLException
		    }
		 
		    void methodTwo() throws IOException
		    {
		        //This method may throw IOException
		    }
		 
		    void methodThree() throws ClassNotFoundException
		    {
		        //This method may throw ClassNotFoundException
		    }
		}
	Throwable In Java :
		Throwable is a super class for all types of errors and exceptions in java. This class is a member of java.lang package. Only instances of this class or it’s sub classes are thrown by the java virtual machine or by the throw statement. The only argument of catch block must be of this type or it’s sub classes. If you want to create your own customized exceptions, then your class must extend this class. Click here to see the hierarchy of exception classes in java.
		Below example shows how to create customized exceptions by extending java.lang.Throwable class.
		class MyException extends Throwable
		{
		           //Customized Exception class
		}
		 
		class ThrowAndThrowsExample
		{
		    void method() throws MyException
		    {
		        MyException e = new MyException();
		 
		        throw e;
		    }
		}
		 
23) What is StackOverflowError in java?
	StackOverflowError is an error which is thrown by the JVM when stack overflows.	
	
24) Can we override a super class method which is throwing an unchecked exception with checked exception in the sub class?
	No. If a super class method is throwing an unchecked exception, then it can be overridden in the sub class with same exception or any other unchecked exceptions but can not be overridden with checked exceptions.

26) Which class is the super class for all types of errors and exceptions in java?
	java.lang.Throwable is the super class for all types of errors and exceptions in java.


In an application, one exception throws many exceptions. i.e one exception causes another exception and that exception causes another exception thus forming chain of exceptions. It is better to know where the actual cause of the exception lies. This is possible with chained exceptions feature of the Java.

26) Which class is the super class for all types of errors and exceptions in java?
		 
		Chained exceptions are introduced from JDK 1.4. To implement chained exceptions in java, two new constructors and two new methods are added in the Throwable class. They are,
		Constructors Of Throwable class Which support chained exceptions in java :
			1) Throwable(Throwable cause)    —-> where cause is the exception that causes the current exception.
			2) Throwable(String msg, Throwable cause)   —-> where msg is the exception message and cause is the exception that causes the current exception.
		Methods Of Throwable class Which support chained exceptions in java :
			1) getCause() method : This method returns actual cause of an exception.
			2) initCause(Throwable cause) method : This method sets the cause for the calling exception.
		Let’s see one example for how to set and get the actual cause of an exception.
		public class ExceptionHandling
		{
		    public static void main(String[] args)
		    {
		        try
		        {
		            //creating an exception
		 
		            NumberFormatException ex = new NumberFormatException("Exception");   
		 
		            //setting a cause of the exception
		 
		            ex.initCause(new NullPointerException("This is actual cause of the exception"));  
		 
		            throw ex;
		        }
		        catch(NumberFormatException ex)
		        {
		            System.out.println(ex);     //displaying the exception
		 
		            System.out.println(ex.getCause());    //getting the actual cause of the exception
		        }
		    }
		}
		
29) Give some examples to checked exceptions?
	ClassNotFoundException, SQLException, IOException

30) Give some examples to unchecked exceptions?
	NullPointerException, ArrayIndexOutOfBoundsException, NumberFormatException		
		
		
			 
 */
	
	
	
	public class ExceptionHandeling {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	
		}
	
	}
