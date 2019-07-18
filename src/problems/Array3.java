package problems;

import java.util.stream.IntStream;

//How do you find the largest and smallest number in an unsorted integer array?

public class Array3 {

	public static void largestOrSmallest(int[] array) {
		
		IntStream of = IntStream.of(array);
		System.out.println("minimum " + of.max().getAsInt());
		System.out.println("maximum " + of.min().getAsInt());
	}
	
	public static void main(String [] args) {
		largestOrSmallest(new int[]{1, 2, 3, 4, 6, 1, 10, 50, 12});
	}
}
