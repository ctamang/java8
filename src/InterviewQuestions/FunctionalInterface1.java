package InterviewQuestions;

import java.util.Arrays;
import java.util.List;

/*
 https://javarevisited.blogspot.com/2018/01/what-is-functional-interface-in-java-8.html
 
 
 
 * 
 */
public class FunctionalInterface1 {

	public static void main(String [] args) {
		String[] arr = {"chandan", "deepak", "kamal", "pankaj","suman", "ram"};
		
		//Arrays.sort(arr);
		List<String> arrList = Arrays.asList(arr);
		arrList.sort((o1,o2) -> o1.compareTo(o2));
		arrList.forEach(i -> System.out.println(i));
		
		System.out.println(arrList);
		System.out.println(arr[5]);
	}
}
