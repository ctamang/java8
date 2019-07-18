package problems;

public class PrimeOrNotSimple {

	public static void main(String[]  args) {
		System.out.println(ifPrime(3));
	}
	private static Boolean ifPrime(int n) {
		if(n%2 == 0) {
			return false;
		}
		for(int i=3;i<n/2;i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
}
