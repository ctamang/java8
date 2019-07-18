package overloading;

//1. we can have a method name with the same name as the class name. we can overload it like that.

/*
 2. Overloading depends upon three thing 
   -method name
   -number of argument
   -type of argument
these three things combined called method signature.
*/

//we can't overload a method by changing just the return type of the method

/*if we have five overloaded methods with different type of arguments

	-void testMethod(long number)
	-void testMethod(int number)
	-void testMethod(Integer number)
	-void testMethod(double number)
	-void testMethod(Number number)
	
	and if we call method like this : testMethod(1)
	then the hierarchy of the method call will be this:
	   ---- int - long - double - Integer - Number
	means if we remove int it will call long, or if we remove long then it will call double and so on..   
*/

/*//we cannot pass null as a parameter to method which is overloaded with same number of parameters because it will create ambiguity.
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
}*/
public class Overloading1 {
	public static void main(String[] args) {
		String s = null;
		testMethod(s);
	}

	public static void testMethod(Long number) {
		System.out.println("Long");
	}

	public static void testMethod(String number) {
		System.out.println("String");
	}
	
	public static void testMethod(Integer number) {
		System.out.println("Integer");
	}
}
