package problems;

import java.util.ArrayList;
import java.util.List;

//How do you find all pairs of an integer array whose sum is equal to a given number? 

public class Array4 {

	@SuppressWarnings("null")
	public static void findPairs(int[] array, int sum) {
		
		List<String> pairs = new ArrayList<>();
		for(int i=0; i<array.length; i++) {
			for(int j=i + 1; j<array.length; j++) {
				if(sum == array[i] + array[j]) {
					pairs.add(array[i] +", " + array[j]);
				}
			}
		}
		pairs.stream().distinct().forEach(item-> System.out.println(item));
	}
	
	public static void main(String [] args) {
		findPairs(new int[] {1, 2, 3, 4, 5, 6, 1, 2, 3}, 5);
	}
}
