package problems;

public class FibonacciUsingRecursion {

	public static void main(String[] args) {

		for(int i=0; i< 10; i++) {
			System.out.println(createFibonacci(i));
		}
	}

	private static int createFibonacci(int a) {
		if(a == 0 || a==1) {
			return 1;
		}
		return createFibonacci(a - 1) + createFibonacci(a - 2);
	}

}
