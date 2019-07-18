package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Java program to find missing elements in a Integer array containing 
 * numbers from 1 to 100.
 *
 * @author Chandan Tamang
 */

public class Array1 {

	public static List<Integer> getMissingNumbers(int [] arr) {
		
		List<Integer> missingNumber = new ArrayList<>();
		int number = 1;
		for(int i=0; i<arr.length; i++ ) {
			if(number != arr[i]) {
				int num = number -1;
				int difference = arr[i] - num;
				for(int j=1; j< difference; j++) {
					missingNumber.add(num + j);
				}
				number = number + difference;
				continue;
			}
			number = number + 1;
		}
		
		return missingNumber;
	}
	
	public static void main(String[] args) {
		System.out.println(getMissingNumbers(new int[]{1, 2, 4, 5, 8, 10,11,12,14,16,19, 25}));
	}
}
