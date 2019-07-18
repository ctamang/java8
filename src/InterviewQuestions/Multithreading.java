package InterviewQuestions;

/*
1.	which is better extending thread class or implementing runnable interface ?
2.	Can we start a thread twice?
3.  	What if we call run() method directly instead start() method?
4.	What does join() method do?
5.	what are daemon threads?
6.	
 
  
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
