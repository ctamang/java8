package InterviewQuestions;

/*
Q1. What is the difference between “==” and “equals(…)” in comparing Java String objects?
A1. When you use “==” (i.e. shallow comparison), you are actually comparing the two object references to see if they point to
	the same object. When you use “equals(…)”, which is a “deep comparison” that compares the actual string values. For example:
	
	public class StringEquals {
	 public static void main(String[ ] args) {
	   String s1 = "Hello";
	   String s2 = new String(s1);
	   String s3 = "Hello";
	 
	   System.out.println(s1 + " equals " + s2 + "--> " +  s1.equals(s2)); //true
	 
	   System.out.println(s1 + " == " + s2 + " --> " + (s1 == s2)); //false
	   System.out.println(s1 + " == " + s3+ " --> " + (s1 == s3)); //true
	 }
	}
	
	The variable s1 refers to the String instance created by “Hello”. The object referred to by s2 is created with s1 as an initializer,
	thus the contents of the two String objects are identical, but they are 2 distinct objects having 2 distinct references s1 and s2. 
	This means that s1 and s2 do not refer to the same object and are, therefore, not ==, but equals( ) as they have the same value 
	“Hello”. The s1 == s3 is true, as they both point to the same object due to internal caching. 
	The references s1 and s3 are interned and points to the same object in the string pool.
	
	String Pool Caches and you create a String object as a literal without the "new" keyword for caching
	Create a String object as a literal without the “new” keyword for caching
	In Java 6 — all interned strings were stored in the PermGen – the fixed size part of heap mainly used for storing loaded classes 
	and string pool.
	In Java 7 – the string pool was relocated to the heap. So, you are not restricted by the limited size.
	 
	reference --- https://www.java-success.com/core-java-interview-questions/

Q2. Can you explain how Strings are interned in Java?
A2. String class is designed with the Flyweight design pattern in mind. Flyweight is all about re-usability without having to create 
	too many objects in memory.
	A pool of Strings is maintained by the String class. When the intern( ) method is invoked, equals(..) method is invoked to 
	determine if the String already exist in the pool. If it does then the String from the pool is returned instead of creating a 
	new object. If not already in the string pool, a new String object is added to the pool and a reference to this object is returned. For any two given strings s1 & s2, s1.intern( ) == s2.intern( ) only if s1.equals(s2) is true.
	
	Two String objects are created by the code shown below. Hence s1 == s2 returns false.
	//Two new objects are created. Not interned and not recommended.
	String s1 = new String("A");
	String s2 = new String("A");
	 
	s1.intern() == s2.intern() returns true, 
	but you have to remember to make sure that you actually do intern() all of the strings that you’re going to compare. It’s easy 
	to forget to intern() all strings and then you can get confusingly incorrect results. Also, why unnecessarily create more objects?
	
	Instead use string literals as shown below to intern automatically:
	String s1 = "A";
	String s2 = "A";
	s1 and s2 point to the same String object in the pool. Hence s1 == s2 returns true.
	
	Since interning is automatic for String literals String s1 = “A”, the intern( ) method is to be used on Strings constructed
	with new String(“A”).
	
Q3. Can you describe what the following code does and what parts of memory the local variables, objects, and references to the objects 
	occupy in Java?

	public class Person {
	    
	    //instance variables
	    private String name;
	    private int age;
	    
	    //constructor
	    public Person(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }
	 
	    public static void main(String[] args) {
	        Person p1 = new Person("John", 25); // "p1" is object refrence in stack pointing to the object in the heap
	        String greeting = "Hello";         // "greeting" is a reference in stack pointing to an Object in Heap String pool
	        p1.addOneAndPrint(greeting);
	    }
	    
	    public void addOneAndPrint(String param) {
	        int valToAdd = 1;                        // local primitive variable in stack
	        this.age  = this.age + valToAdd;         // instance variable in heap is mutated to 26 via "param" reference in stack
	        System.out.println(param + "! " + this); // calls toString() method
	    }
	 
	    @Override
	    public String toString() {
	        return name + " you are now " + age;
	    }
	}
A3. The above code outputs “Hello! John you are now 26”. The following diagram depicts how the different variable references & 
 	actual objects get stored.
	Stack: is where local variables both primitives like int, float, etc & references to objects in the heap and method parameters 
	are stored as shown in the above diagram.
	Heap: is where objects are stored. For example, an instance of “Person” with name=”John” and age=25. Strings will be stored in
	String Pool within the heap.
	
Q4. Why String class has been made immutable in Java?
A4. For performance & thread-safety.
	1. Performance: Immutable objects are ideal for representing values of abstract data (i.e. value objects) types like numbers, 
	   enumerated types, etc. If you need a different value, create a different object. In Java, Integer, Long, Float, Character, 
	   BigInteger and BigDecimal are all immutable objects. Optimization strategies like caching of hashcode, caching of objects, 
	   object pooling, etc can be easily applied to improve performance. If Strings were made mutable, string pooling would not 
	   be possible as changing the string with one reference will lead to the wrong value for the other references.
	
	2. Thread safety as immutable objects are inherently thread safe as they cannot be modified once created. They can only be used 
	   as read only objects. They can easily be shared among multiple threads for better scalability.	
	
Q5. Why is a char array i.e char[] preferred over String to store a password?
A5. String is immutable in Java and stored in the String pool. Once it is created it stays in the pool until garbage collected. This 
	has greater risk of 
		1) someone producing a memory dump to find the password 
		2) the application inadvertently logging password as a readable string.
	If you use a char[] instead, you can override it with some dummy values once done with it, and also logging the char[] 
	like “[C@5829428e” is not as bad as logging it as String “password123”.	

***************************************************
***************************************************
1) Is String a keyword in java?
   No. String is not a keyword in java. String is a final class in java.lang package which is used to represent the set of
   characters in java.
   
2) Is String a primitive type or derived type?
   String is a derived type.  
  
3) In how many ways you can create string objects in java?
	There are two ways to create string objects in java. One is using new operator and another one is using string literals. 
	The objects created using new operator are stored in the heap memory and objects created using string literals are stored 
	in string constant pool.
	String s1 = new String("abc");          //Creating string object using new operator
	String s2 = "abc";        //Creating string object using string literal   
	
4) What is string constant pool?
	String objects are most used data objects in Java. Hence, java has a special arrangement to store the string objects. String 
	Constant Pool is one such arrangement. String Constant Pool is the memory space in heap memory specially allocated to store 
	the string objects created using string literals. 
	In String Constant Pool, there will be no two string objects having the same content.
	Whenever you create a string object using string literal, JVM first checks the content of the object to be created. If there 
	exist an object in the string constant pool with the same content, then it returns the reference of that object. It doesn’t 
	create a new object. If the content is different from the existing objects then only it creates new object.	

5) What is special about string objects as compared to objects of other derived types?
	One special thing about string objects is that you can create string objects without using new operator i.e using string 
	literals. This is not possible with other derived types (except wrapper classes). One more special thing about strings is that 
	you can concatenate two string objects using ‘+’. This is the relaxation java gives to string objects as they will be used most
	of the time while coding. And also java provides string constant pool to store the string objects.	

6) What do you mean by mutable and immutable objects?
	Immutable objects are like constants. You can’t modify them once they are created. They are final in nature. Where as mutable objects
 	are concerned, you can perform modifications to them.	

7) Which is the final class in these three classes – String, StringBuffer and StringBuilder?
	All three are final. (Interviewer will ask this type of questions to confuse you) 	
 	
8) What is the difference between String, StringBuffer and StringBuilder?
	String objects created using java.lang.String class are immutable. Once they are created, they can not be modified. If you try 
	to modify them, a new string object will be created with modified content. This property of String class may cause some memory 
	issues for applications which need frequent modification of string objects. To overcome this behavior of String class, two more 
	classes are introduced in Java to represent the strings. They are StringBuffer and StringBuilder. Both these classes are also 
	members of java.lang package same as String class.
	Immutability :
		This is main reason why StringBuffer and StringBuilder are introduced. As objects of String class are immutable, objects of 
		StringBuffer and StringBuilder class are mutable. You can change the contents of StringBuffer and StringBuider objects at 
		any time of execution. When you change the content, new objects are not created. Instead of that the changes are applied 
		to existing object. Thus solving memory issues caused by String class.
		
	Object Creation :
		You have to use ‘new‘ operator to create objects to StringBuffer and StringBuilder classes. You can’t use string literals 
		to create objects to these classes. For example, you can’t write StringBuffer sb = “JAVA” or StringBuilder sb = “JAVA”. It 
		gives compile time error. But, you can use both string literals and new operator to create objects to String class.
		
	Storage Area :
		As objects of StringBuffer and StringBuilder are created using only new operator, they are stored in heap memory. Where as 
		objects of String class are created using both string literals and new operator, they are stored in string constant pool as 
		well as heap memory.
		
	Thread Safety :
		Any immutable object in java is thread safe. Because they are unchangeable once they are created. Any type of thread can’t 
		change the content of immutable object. This applies to objects of String class also. Of the StringBuffer and StringBuilder 
		objects, only StringBuffer objects are thread safe. All necessary methods in StringBuffer class are synchronized so that only
		one thread can enter into it’s object at any point of time. Where as StringBuilder objects are not thread safe.
		
	Performance :
		Because of thread safety property of String and StringBuffer classes, they reduces the performance of multi-threaded 
		applications. Because, multiple threads can’t enter into objects of these classes simultaneously. One thread has to wait 
		until another thread is finished with them. But, you will not find performance problems if you use StringBuilder class. 
		Becuase, multiple threads can enter into objects of this class. But, be aware that StringBuilder is not thread safe.
		
	String Concatenation :
		There will be serious performance issues when you are performing lots of string concatenation using String class. This is 
		because, each time you perform string concatenation using string class, a new object will be created with the concatenated 
		string. This slows down an application. But, if you use either StringBuffer or StringBuilder instead of String class, 
		your application will perform better. Below program shows time taken by all three classes to perform string concatenation 
		10000 times.
		public class StringExamples
		{
		    public static void main(String[] args)
		    {
		        String s = "JAVA";
		        long startTime = System.currentTimeMillis();
		        for(int i = 0; i <= 10000; i++)
		        {
		            s = s + "J2EE";
		        }
		        long endTime = System.currentTimeMillis();
		        System.out.println("Time taken by String class : "+(endTime - startTime)+" ms");
		        StringBuffer sb = new StringBuffer("JAVA");
		        startTime = System.currentTimeMillis();
		        for(int i = 0; i <= 10000; i++)
		        {
		            sb.append("J2EE");
		        }
		        endTime = System.currentTimeMillis();
		        System.out.println("Time taken by StringBuffer class : "+(endTime - startTime)+" ms");
		        StringBuilder sb1 = new StringBuilder("JAVA");
		        startTime = System.currentTimeMillis();
		        for(int i = 0; i <= 10000; i++)
		        {
		            sb1.append("J2EE");
		        }
		        endTime = System.currentTimeMillis();
		        System.out.println("Time taken by StringBuilder class : "+(endTime - startTime)+" ms");
		    }
		}
		Output :
		Time taken by String class : 429 ms
		Time taken by StringBuffer class : 2 ms
		Time taken by StringBuilder class : 0 ms
		
	Therefore, when you are performing lots of string concatenation in your application, it is better to use StringBuffer class 
	(if you need thread safety) or StringBuilder class (If you don’t need thread safety).
	
	equals() and hashCode() Methods :
		In StringBuffer and StringBuilder classes, equals() and hashCode methods are not overrided. Where as in String class they are overrided.
	
	toString() Method :
		toString() method is overrided in all three classes. You can also convert StringBuffer and StringBuilder objects to String 
		type by calling toString() method on them.
9) Why StringBuffer and StringBuilder classes are introduced in java when there already exist String class to represent the set of characters?
	The objects of String class are immutable in nature. i.e you can’t modify them once they are created. If you try to modify them,
	a new object will be created with modified content. This may cause memory and performance issues if you are performing lots of 
	string modifications in your code. To overcome these issues, StingBuffer and StringBuilder classes are introduced in java.		
	
10) How many objects will be created in the following code and where they will be stored in the memory?
	String s1 = "abc";
	String s2 = "abc";
	Only one object will be created and this object will be stored in the string constant pool.

11) How do you create mutable string objects?
	Using StringBuffer and StringBuilder classes. These classes provide mutable string objects.

12) Which one will you prefer among “==” and equals() method to compare two string objects?
	I prefer equals() method because it compares two string objects based on their content. That provides more logical comparison 
	of two string objects. If you use “==” operator, it checks only references of two objects are equal or not. It may not be 
	suitable in all situations. So, rather stick to equals() method to compare two string objects. 

13) Which class will you recommend among String, StringBuffer and StringBuilder classes if I want mutable and thread safe objects?
	StringBuffer

14) How do you convert given string to char array?
	Using toCharArray() method.
	
15) How many objects will be created in the following code and where they will be stored?
	String s1 = new String("abc");
	String s2 = "abc";
	Here, two string objects will be created. Object created using new operator(s1) will be stored in the heap memory. The object 
	created using string literal(s2) is stored in the string constant pool.

16) Where exactly string constant pool is located in the memory?
	Inside the heap memory. JVM reserves some part of the heap memory to store string objects created using string literals.

17) I am performing lots of string concatenation and string modification in my code. which class among string, StringBuffer and 
	StringBuilder improves the performance of my code. Remember I also want thread safe code?
	StringBuffer class gives better performance in this scenario. As String class is immutable, if you use this class, a new object
	will be created after every string concatenation or string modification. This will lower the performance of the code. You can 
	use StringBuilder also, but it is not thread safe. So, StringBuffer will be optimal choice here.

18) What is string intern?
	String object in the string constant pool is called as String Intern. You can create an exact copy of heap memory string object 
	in string constant pool. This process of creating an exact copy of heap memory string object in the string constant pool is 
	called interning. intern() method is used for interning.

20) How many objects will be created in the following code and where they will be stored?
	String s1 = new String("abc");
	String s2 = new String("abc");
	The answer is 3.
	First – line 1, “Hello” object in the string pool.
	Second – line 1, new String with value “Hello” in the heap memory.
	Third – line 2, new String with value “Hello” in the heap memory. Here “Hello” string from string pool is reused.

21) Can we call String class methods using string literals?
	Yes, we can call String class methods using string literals. Here are some examples,
	"abc".charAt(0)
	"abc".compareTo("abc")
	"abc".indexOf('c')
		
22) do you have any idea why strings have been made immutable in java?		
	The string is Immutable in Java because String objects are cached in String pool. Since cached String literals are shared between 
	multiple clients there is always a risk, where one client's action would affect all another client. For example, if one client 
	changes the value of String "Test" to "TEST", all other clients will also see that value as explained in the first example. 
	Since caching of String objects was important from performance reason this risk was avoided by making String class Immutable. 
	At the same time, String was made final so that no one can compromise invariant of String class e.g. Immutability, Caching, 
	hashcode calculation etc by extending and overriding behaviors. Another reason of why String class is immutable could die due 
	to HashMap.
	Since Strings are very popular as HashMap key, it's important for them to be immutable so that they can retrieve the value 
	object which was stored in HashMap. Since HashMap works in the principle of hashing, which requires same hash value to function
	properly. Mutable String would produce two different hashcodes at the time of insertion and retrieval if contents of String 
	was modified after insertion, potentially losing the value object in the map.
	
23) Why String is Final in Java
	1. As I said, there could be many possible answers to this question, and the only designer of String class can answer it with
		confidence. I was expecting some clue in Joshua Bloch's Effective Java book, but he also didn't mention it. I think following 
		two reasons make a lot of sense on why String class is made Immutable or final in Java: 1) Imagine String pool facility without 
		making string immutable , its not possible at all because in case of string pool one string object/literal e.g. "Test" has 
		referenced by many reference variables, so if any one of them change the value others will be automatically gets affected i.e. 
		lets say
		String A = "Test"
		String B = "Test"
		Now String B called, "Test".toUpperCase() which change the same object into "TEST", so A will also be "TEST" which is not 
	2.  String has been widely used as parameter for many Java classes e.g. for opening network connection, you can pass hostname 
		and port number as string, you can pass database URL as a string for opening database connection, you can open any file in 
		Java by passing the name of the file as argument to File I/O classes.
		In case, if String is not immutable, this would lead serious security threat, I mean someone can access to any file for 
		which he has authorization, and then can change the file name either deliberately or accidentally and gain access to that 
		file. Because of immutability, you don't need to worry about that kind of threats. This reason also gels with, Why String is 
		final in Java, by making java.lang.String final, Java designer ensured that no one overrides any behavior of String class.
	3.  Another reason of Why String is immutable in Java is to allow String to cache its hashcode, being immutable String in Java 
		caches its hashcode, and do not calculate every time we call hashcode method of String, which makes it very fast as hashmap 
		key to be used in hashmap in Java. In short because String is immutable, no one can change its contents once created which 
		guarantees hashCode of String to be same on multiple invocations.
	4.  Another good reason of Why String is immutable in Java :The absolutely most important reason that String is immutable is that 
		it is used by the class loading mechanism, and thus have profound and fundamental security aspects. Had String been mutable, 
		a request to load "java.io.Writer" could have been changed to load "mil.vogoon.DiskErasingWriter".
		
24) What is the similarity and difference between String and StringBuffer class?
	The main similarity between String and StringBuffer class is that both are thread safe. The main difference between them is that
	String objects are immutable where as StringBuffer objects are mutable.

25) What is the similarity and difference between StringBuffer and StringBuilder class?
	The main similarity between StringBuffer and StringBuilder class is that both produces mutable string objects. The main difference 
	between them is that StringBuffer class is thread safe where as StringBuilder class is not thread safe.

******************************************************

Can we use String in switch case?
	This is a tricky question used to check your knowledge of current Java developments. Java 7 extended the capability of switch 
	case to use Strings also, earlier Java versions don’t support this.
	If you are implementing conditional flow for Strings, you can use if-else conditions and you can use switch case if you are 
	using Java 7 or higher versions.
	
How to convert String to byte array and vice versa?
	We can use String getBytes() method to convert String to byte array and we can use String constructor new String(byte[] arr) to 
	convert byte array to String.

Why String is immutable or final in Java
	There are several benefits of String because it’s immutable and final.
	String Pool is possible because String is immutable in java.
	It increases security because any hacker can’t change its value and it’s used for storing sensitive information such as database 
	username, password etc.
	Since String is immutable, it’s safe to use in multi-threading and we don’t need any synchronization.
	Strings are used in java classloader and immutability provides security that correct class is getting loaded by Classloader.
	
Why Char array is preferred over String for storing password?
	String is immutable in Java and stored in String pool. Once it’s created it stays in the pool until unless garbage collected, 
	so even though we are done with password it’s available in memory for longer duration and there is no way to avoid it. It’s a 
	security risk because anyone having access to memory dump can find the password as clear text.
	If we use a char array to store password, we can set it to blank once we are done with it. So we can control for how long it’s 
	available in memory that avoids the security threat with String.	
	
What is String Pool?
	As the name suggests, String Pool is a pool of Strings stored in Java heap memory. We know that String is a special class in 
	Java and we can create String object using new operator as well as providing values in double quotes.

What does String intern() method do?
	When the intern method is invoked, if the pool already contains a string equal to this String object as determined by the 
	equals(Object) method, then the string from the pool is returned. Otherwise, this String object is added to the pool and a 
	reference to this String object is returned.
	This method always returns a String that has the same contents as this string but is guaranteed to be from a pool of unique 
	strings.

Does String is thread-safe in Java?
	Strings are immutable, so we can’t change it’s value in program. Hence it’s thread-safe and can be safely used in multi-threaded 
	environment.

Why String is popular HashMap key in Java?
	Since String is immutable, its hashcode is cached at the time of creation and it doesn’t need to be calculated again. This makes 
	it a great candidate for the key in a Map and it’s processing is fast than other HashMap key objects. This is why String is 
	mostly used Object as HashMap keys.	
	
	
	
*			
 * 
 */

public class Strings {
	public void foo(Integer s) {
		System.out.println("String");
	}

	public void foo(String sb) {
		System.out.println("StringBuffer");
	}

	public static void main(String[] args) {
		new Strings().foo("int");
	}}
