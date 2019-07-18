package InterviewQuestions;

/* 1. we can have a method name with the same name as the class name. we can overload it like that.

/*
 2. Overloading depends upon three thing 
	   -method name
	   -number of argument
	   -type of argument
	these three things combined called method signature.


	//we can't overload a method by changing just the return type of the method
	e.g. 
		public class Overloading1 {
		public static void main(String[] args) {
			String s = null;
			testMethod(s);
		}
	
		public static int testMethod(Long number) {
			System.out.println("Long");
			return 1;
		}
	
		public static double testMethod(Long number) {
			System.out.println("String");
			return 2d;
		}
	}

if we have five overloaded methods with different type of arguments
	-void testMethod(long number)
	-void testMethod(int number)
	-void testMethod(Integer number)
	-void testMethod(double number)
	-void testMethod(Number number)
	
	and if we call method like this : testMethod(1)
	then the hierarchy of the method call will be this:
	   ---- int - long - double - Integer - Number
	means if we remove int it will call long, or if we remove long then it will call double and so on..   


we cannot pass null as a parameter to method which is overloaded with same number of parameters because it will create ambiguity.
	public class Overloading1 {
	public static void main(String[] args) {
		testMethod(null);
	}

	public static void testMethod(Long number) {
		System.out.println("Long");
	}

	public static void testMethod(Integer number) {
		System.out.println("Integer");
	}
	}
	although if we have methods overloaded with more different number of arguments then it will work fine.
	like this : 
		public static void testMethod(Long number) {
			System.out.println("Long");
		}
	
		public static void testMethod(Integer number, Float f) {
			System.out.println("Integer");
		}
}

Q)  Can overloaded method be overrided?
	Yes, we can override a method which is overloaded in super class.

*****************************************
OUTPUT QUESTIONS
*****************************************
1) What is the output of the following program?
	public class Test 
	{ 
	    public int getData() //getdata() 1 
	    { 
	        return 0; 
	    } 
	    public long getData() //getdata 2 
	    { 
	        return 1; 
	    } 
	    public static void main(String[] args) 
	    { 
	        Test obj = new Test(); 
	        System.out.println(obj.getData());     
	    } 
	} 
	a) 1
	b) 0
	c) Runtime error
	d) Compilation error
	
	Ans. (d)
	Explanation: For method overloading, methods must have different signatures. Return type of methods does not contribute towards different method signature, so the code above give compilation error. Both getdata 1 and getdata 2 only differ in return types and NOT signatures.
	 
2) What is the output of the following program?
	public class Test 
	{ 
	    public int getData(String temp) throws IOException 
	    { 
	        return 0; 
	    } 
	    public int getData(String temp) throws Exception 
	    { 
	        return 1; 
	    } 
	    public static void main(String[] args) 
	    { 
	        Test obj = new Test(); 
	        System.out.println(obj.getData("GFG"));     
	    } 
	} 
	a) 0
	b) 1
	c) Compilation error
	d) Runtime error
	
	Ans. (c)
	Explanation: Methods that throws different exceptions are not overloaded as their signature are still the same.

3) What is the output of the following program?
	public class Test 
	{ 
	    private String function() 
	    { 
	        return ("GFG"); 
	    } 
	    public final static String function(int data) 
	    { 
	        return ("GeeksforGeeks"); 
	    } 
	    public static void main(String[] args) 
	    { 
	        Test obj = new Test(); 
	        System.out.println(obj.function());     
	    } 
	} 
	a) Compilation error
	b) Runtime error
	c) GFG
	d) None of these
	
	Ans. (c)
	Explanation: Access modifiers associated with methods doesn’t determine the criteria for overloading. The overloaded methods could also be declared as final or static without affecting the overloading criteria.

4) What is the output of the following program?
	public class Test 
	{ 
	    private String function(String temp, int data) 
	    { 
	        return ("GFG"); 
	    } 
	    private String function(int data, String temp) 
	    { 
	        return ("GeeksforGeeks"); 
	    } 
	    public static void main(String[] args) 
	    { 
	        Test obj = new Test(); 
	        System.out.println(obj.function(4, "GFG"));     
	    } 
	} 
	a) GFG
	b) GeeksforGeeks
	c) Compilation error
	d) Runtime error
	
	Ans. (b)
	Explanation: The order of argument are an important parameter for determining method overloading. As the order of attributes are different, the methods are overloaded.

5) What is the output of the following program?
	public class Test 
	{ 
	    private String function(String temp, int data, int sum) 
	    { 
	        return ("GFG"); 
	    } 
	    private String function(String temp, int data) 
	    { 
	        return ("GeeksforGeeks"); 
	    } 
	    public static void main(String[] args) 
	    { 
	        Test obj = new Test(); 
	        System.out.println(obj.function("GFG", 0, 20));     
	    } 
	} 
	a) GFG
	b) Compilation error
	c) Runtime error
	d) GeeksforGeeks
	
	Ans. (a)
	Explanation: This one is really simple. Different number of arguments contribute towards method overloading as the signature of methods is changed with different number of attributes. Whichever matches the attributes is obviously called in Method Overloading.

6 ) 
	class A
	{
	     
	}
	 
	class B extends A
	{
	     
	}
	 
	class C extends B
	{
	     
	}
	 
	public class MainClass 
	{
	    static void overloadedMethod(A a)
	    {
	        System.out.println("ONE");
	    }
	     
	    static void overloadedMethod(B b)
	    {
	        System.out.println("TWO");
	    }
	     
	    static void overloadedMethod(Object obj)
	    {
	        System.out.println("THREE");
	    }
	     
	    public static void main(String[] args)
	    {
	        C c = new C();
	         
	        overloadedMethod(c);
	    }
	}
	Answer : TWO
	
7 ) In the below class, is ‘method’ overloaded or duplicated?
	public class MainClass 
	{
	    void method(int ... a)
	    {
	        System.out.println(1);
	    }
	     
	    void method(int[] a)
	    {
	        System.out.println(2);
	    }
	}
	
	Answer : Duplicated. Because, var args (int … a) are nothing but the arrays. So here, (int … a) and (int[] a) are the same.
	
8 ) Method signature consists of
	a) Method Name, Return Type and Number Of Arguments
	b) Access Modifier, Method Name and Types Of Arguments
	c) Method Name, Number Of Arguments, Types Of Arguments and Order Of Arguments
	d) Return Type, Access Modifier and Order Of Arguments
	Answer : c) Method Name, Number Of Arguments, Types Of Arguments and Order Of Arguments


Coding Questions: --------
****************************************************************
https://javaconceptoftheday.com/java-practice-questions-on-method-overloading-and-overriding/2/

****************************************************************
}*/

class SuperClass
{
    void superClassMethod(Number n)
    {
        System.out.println("From Super Class");
    }
}
 
class SubClass extends SuperClass
{
    void superClassMethod(Double d)
    {
        System.out.println("From Sub Class");
    }
}
 
public class Overloading1 
{   
    public static void main(String[] args)
    {
        SubClass sub = new SubClass();
         
        sub.superClassMethod(1233214687);
    }
}

