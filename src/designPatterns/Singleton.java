package designPatterns;

/*Singleton design pattern is used when you want to have only one instance of a given class.
It is a creational design pattern wherein we deal with the creation of objects.

Motivation and Real world examples
In object-oriented design, It’s very important for some classes to have only one instance. That’s because they represent something 
unique, something that’s one of its kind.Let’s see some real-world examples of Singletons from the Java language to understand what that means -
1. java.lang.Runtime: Java provides a Runtime class that represents the current runtime environment in which an application is 
	running. The application can interface with its runtime environment using this class.
	Since the Runtime environment is unique, There should only be one instance of this class.
2. java.awt.Desktop: The Desktop class allows Java applications to launch a URI or a file with the applications that are registered 
	on the native Desktop like the user’s default browser, or mail client.
	The native Desktop and the associated applications are one-of-a-kinds. So there must be only one instance of the Desktop class.

*******************************************
Implementing the Singleton Design Pattern
*******************************************
How do you ensure that a class has only one instance? Well, there are several ways of doing this in Java. But all of them are based 
on the following basic ideas:
	1. Declare a private constructor to prevent others from instantiating the class.
	2. Create the instance of the class either during class loading in a static field/block, or on-demand in a static method that 
	first checks whether the instance exists or not and creates a new one only if it doesn’t exist.
Let’s see all the possible solutions with code samples one by one:

1. Eagerly Initialized Singleton
		This is the simplest approach wherein the instance of the class is created at the time of class loading -
		public class EagerSingleton {
		
		    *//** private constructor to prevent others from instantiating this class *//*
		    private EagerSingleton() {}
		
		    *//** Create an instance of the class at the time of class loading *//*
		    private static final EagerSingleton instance = new EagerSingleton();
		
		    *//** Provide a global point of access to the instance *//*
		    public static EagerSingleton getInstance() {
		        return instance;
		    }
		}
	The disadvantage of this approach is that the instance is created irrespective of whether it is accessed or not. This is fine if 
	the object is simple and does not hold any system resources. But can have performance implications if it allocates a large amount
	of system resources and remains unused.
2. Eagerly Initialized Static Block Singleton
	You can also create the one-off instance of the class in a static block. This works because the static block is executed only once at the time of class loading.
	The advantage with static block initialization is that you can write your initialization logic or handle exceptions in the static block.
	public class EagerStaticBlockSingleton {

	    private static final EagerStaticBlockSingleton instance;

	    *//** Don't let anyone else instantiate this class *//*
	    private EagerStaticBlockSingleton() {}

	    *//** Create the one-and-only instance in a static block *//*
	    static {
	        try {
	            instance = new EagerStaticBlockSingleton();
	        } catch (Exception ex) {
	            throw ex;
	        }
	    }

	    *//** Provide a public method to get the instance that we created *//*
	    public static EagerStaticBlockSingleton getInstance() {
	        return instance;
	    }
	}
	Just like the previous solution, the instance is created whether or not it is needed by the application.

3. Lazily Initialized Singleton
	Lazy initialization means delaying the initialization of something until the first time it is needed.
	In the following implementation, we first check whether the instance is already created or not in the getInstance() method. If 
	the instance is already created, we simply return it, otherwise, we first create the instance and then return it:

	public class LazySingleton {

	    private static LazySingleton instance;

	    *//** Don't let anyone else instantiate this class *//*
	    private LazySingleton() {}

	    *//** Lazily create the instance when it is accessed for the first time *//*
	    public static synchronized LazySingleton getInstance() {
	        if(instance == null) {
	            instance = new LazySingleton();
	        }
	        return instance;
	    }
	}
	Notice the use of synchronized keyword in the getInstance() method. This is needed to prevent race conditions in multi-threaded 
	environments.
	Let’s say that the instance is not created yet, and two threads enter the getInstance() method simultaneously. In that case, the 
	instance==null check will evaluate to true and both the threads will create a new instance of the class.
	The synchronized keyword ensures that only one thread can execute the getInstance() method at a time.
	
4. Lazily Initialized Double-Checked Locking Singleton
	The synchronized keyword added to the getInstance() method prevents race conditions, but it also incurs some performance penalty.
	Following is an optimized version of the lazily initialized singleton where - instead of making the entire method synchronized, 
	we create a synchronized block and wrap only the instantiation part inside the synchronized block -

	public class LazyDoubleCheckedLockingSingleton {

	    private static volatile LazyDoubleCheckedLockingSingleton instance;

	    *//** private constructor to prevent others from instantiating this class *//*
	    private LazyDoubleCheckedLockingSingleton() {}

	    *//** Lazily initialize the singleton in a synchronized block *//*
	    public static LazyDoubleCheckedLockingSingleton getInstance() {
	        if(instance == null) {
	            synchronized (LazyDoubleCheckedLockingSingleton.class) {
	                // double-check
	                if(instance == null) {
	                    instance = new LazyDoubleCheckedLockingSingleton();
	                }
	            }
	        }
	        return instance;
	    }
	}
	The above approach is called Double-Checked Locking because we double-check whether the variable is initialized or not inside 
	the synchronized block.The double-checking is very important here. Let’s say that two threads T1 and T2 enter the getInstance() 
	method simultaneously. The instance==null check will evaluate to true, so both of them will enter the synchronized block 
	one-by-one. If the double check was not there, both threads would create a new instance.
	Also, notice the use of volatile keyword with the instance variable. This is necessary to prevent compilers from doing their 
	own optimizations and handle the singleton correctly.

5. Lazily Initialized Inner Class Singleton (Bill Pugh singleton)
	Bill Pugh came up with a very efficient solution to create singletons. It is called Initialization-on-demand holder idiom.In 
	this approach, a static inner class is used to lazily create a singleton instance.
	public class LazyInnerClassSingleton {

	    *//** private constructor to prevent others from instantiating this class *//*
	    private LazyInnerClassSingleton() {}

	    *//** This inner class is loaded only after getInstance() is called for the first time. *//*
	    private static class SingletonHelper {
	        private static final LazyInnerClassSingleton INSTANCE = new LazyInnerClassSingleton();
	    }

	    public static LazyInnerClassSingleton getInstance() {
	        return SingletonHelper.INSTANCE;
	    }
	}
	Note that, the inner class is not loaded until the getInstance() method is invoked for the first time. This solution is 
	thread-safe and doesn’t require any synchronization. It is the most efficient approach among all the singleton design pattern 
	implementations.
	*/
public class Singleton {

}
