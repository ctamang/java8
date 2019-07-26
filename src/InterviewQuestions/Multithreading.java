package InterviewQuestions;

/*
1.	which is better extending thread class or implementing runnable interface ?
2.	Can we start a thread twice?
3.  	What if we call run() method directly instead start() method?
4.	What does join() method do?
5.	what are daemon threads?

**********************************
Multithreading Interview Questions
**********************************
1) What is multithreading?
	Multithreading is a process of executing multiple threads simultaneously. Multithreading is used to obtain the multitasking. It 
	consumes less memory and gives the fast and efficient performance. Its main advantages are:
		1. Threads share the same address space.
		2. The thread is lightweight.
		3. The cost of communication between the processes is low.
2) What is the thread?
	A thread is a lightweight subprocess. It is a separate path of execution because each thread runs in a different stack frame. A 
	process may contain multiple threads. Threads share the process resources, but still, they execute independently.	 
 
 3) Differentiate between process and thread?
	There are the following differences between the process and thread.
		1. A Program in the execution is called the process whereas; A thread is a subset of the process
		2. Processes are independent whereas threads are the subset of process.
		3. Process have different address space in memory, while threads contain a shared address space.
		4. Context switching can be faster between the threads as compared to context switching between the threads.
		5. Inter-process communication is slower and expensive than inter-thread communication.
		6. Any change in Parent process doesn't affect the child process whereas changes in parent thread can affect the child thread.
4) What do you understand by inter-thread communication?
	The process of communication between synchronized threads is termed as inter-thread communication.
	Inter-thread communication is used to avoid thread polling in Java.
	The thread is paused running in its critical section, and another thread is allowed to enter (or lock) in the same critical 
	section to be executed.
	It can be obtained by wait(), notify(), and notifyAll() methods. 
	
5) What is the purpose of wait() method in Java?
	The wait() method is provided by the Object class in Java. This method is used for inter-thread communication in Java. The 
	java.lang.Object.wait() is used to pause the current thread, and wait until another thread does not call the notify() or 
	notifyAll() method. Its syntax is given below.
		public final void wait()
		
6) Why must wait() method be called from the synchronized block?
	We must call the wait method otherwise it will throw java.lang.IllegalMonitorStateException exception. Moreover, we need wait() 
	method for inter-thread communication with notify() and notifyAll(). Therefore It must be present in the synchronized block for 
	the proper and correct communication.
	we call wait (), notify () or notifyAll method in Java from synchronized method or synchronized block in Java to avoid:
		1) IllegalMonitorStateException in Java which will occur if we don't call wait (), notify () or notifyAll () method from 
			synchronized context.
		2) Any potential race condition between wait and notify method in Java.


Read more: https://javarevisited.blogspot.com/2011/05/wait-notify-and-notifyall-in-java.html#ixzz5uJ2pYtR8



 */
public class Multithreading implements Runnable{

	public static void main(String[] args) {
		
		Multithreading m = new Multithreading();
		Thread t = new Thread(m);
		Thread t2 = new Thread(m);
		
		t.start();
		t2.start();
		
		Thread t3 = new Thread(() -> System.out.println("thread is running"));
		t3.start();
	}
	@Override
	public void run() {
		System.out.println("thread is running")	;	
	}
}
