package java8programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {

	public static void main(String[] args) {

		// 1. Integer stream
		IntStream.range(1,10).forEach(System.out::print);
		
		System.out.println();
		
		// 2. Integer stream with skip
		IntStream.range(1,10).skip(5).forEach(x ->System.out.print(x));
	
		System.out.println();
		
		// 3. Integer stream with sum
		int sum = IntStream.range(1,10).sum();
		System.out.println(sum);
		
		// 4. Stream.of, Sorted and findFirst
		Stream.of("Ava", "Aneri", "Alberto")
					.sorted()
					.findFirst()
					.ifPresent(System.out::print);
		
		System.out.println();
		
		//5. Stream from array, sort, filter and print
		String[] names = {"Al", "Ankit", "Kushal", "Sarika", "Brent", "Amanda", "Hans", "shivika", "Chandan", "Deepak", "Pankaj"};
		Arrays.stream(names)
					.filter(x -> x.startsWith("A"))
					.sorted()
					.forEach(X -> System.out.print(" " + X));
		
		System.out.println();
		
		//6. Average of square of an int array
		Arrays.stream(new int[] {2, 4, 6, 8})
				.map(x -> x + x)
				.average()
				.ifPresent(System.out::print);
		System.out.println();
		
		//7. Stream from list filter and print
		List<String> nameList = Arrays.asList("Al", "Ankit", "Kushal", "Sarika", "Brent", "Amanda", "Hans", "shivika", "Chandan", "Deepak", "Pankaj");
		nameList
			.stream()
			.map(x -> x.toUpperCase())   //map(String::toUpperCase)
			.filter(x ->x.startsWith("A"))
			.forEach(x -> System.out.print(x + " "));
		System.out.println();
	}

}
