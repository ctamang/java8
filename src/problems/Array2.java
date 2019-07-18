package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Java program to remove duplicates from this array. You don't
 * need to physically delete duplicate elements, replacing with null, or
 * empty or default value is ok.
 *
 * @author Chandan Tamang
 */

public class Array2 {

	public static Set<Integer> removeDuplicate(int[] array) {
		
		Set<Integer> noDuplicateList = new HashSet<>();
		for(int n : array) {
			noDuplicateList.add(n);
		}
		return noDuplicateList;
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicate(new int[] {2, 1, 4, 5, 6, 1, 8, 2, 6, 1}));
	}
}
