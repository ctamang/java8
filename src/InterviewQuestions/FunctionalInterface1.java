package InterviewQuestions;

import java.util.Arrays;

/*
 https://javarevisited.blogspot.com/2018/01/what-is-functional-interface-in-java-8.html
 
 
 
 * 
 */
public class FunctionalInterface1 {

	public static void main(String [] args) {
		String[] arr = {"chandan", "deepak", "kamal", "pankaj","suman", "ram"};
		
		Arrays.sort(arr);
		
		System.out.println(arr[5]);
	}
}
