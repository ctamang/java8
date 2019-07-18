package problems;

public class FibonacciSimple {
	public static void main(String [] args) {
		int a = 0;
		int b = 1;
		for(int i=0; i<10; i++) {
			b = a + b;
			a = b - a;
			System.out.println(a); 
		}
	}

}
