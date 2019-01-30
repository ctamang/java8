package java8programs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {

	public static void main(String[] args) throws IOException {

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
		
		Stream<String> bands = Files.lines(Paths.get("bands.txt"));
		
		bands
			.sorted()
			.filter(x -> x.length() > 13)
			.forEach(x -> System.out.println(x));	
		bands.close();
		System.out.println();
		
		//stream rows from text file and save it to the list
		List<String> bands2 = Files.lines(Paths.get("bands.txt"))
									.filter(x -> x.contains("Green"))
									.collect(Collectors.toList());
		
		bands2.forEach(x -> System.out.println(x));
		System.out.println();
		
		//Stream rows from CSV file and count
		Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
		int rowCount = (int)rows1
							.map(x -> x.split(","))
							.filter(x -> x.length == 3)
							.count();
		System.out.println(rowCount);
		rows1.close();
		System.out.println();
		
		//Stream rows from CSV file and parse data from rows
		Stream<String> rows2 = Files.lines(Paths.get("data.txt"));
		rows2
			.map(x -> x.split(","))
			.filter(x -> x.length == 3)
			.filter(x -> Integer.parseInt(x[1]) > 15)
			.forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
		rows2.close();
		
		System.out.println();
		
		//Stream rows from CSV file and store data in HashMap
		Stream<String> rows3 = Files.lines(Paths.get("data.txt"));
		Map<String, Integer> map = new HashMap<>();
		map = rows3
			.map(x -> x.split(","))
			.filter(x -> x.length == 3)
			.filter(x -> Integer.parseInt(x[1]) > 15)
			.collect(Collectors.toMap(x -> x[0], x->Integer.parseInt(x[1])));
		rows3.close();
		for(String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println();
		
		//Stream rows from CSV file and do sum
		Stream<String> rows4 = Files.lines(Paths.get("data.txt"));
		
		List<String[]> collect = rows4
			.map(x -> x.split(","))
			.filter(x -> x.length ==3)
			.collect(Collectors.toList());
		Double sumDouble =collect.stream().mapToDouble(x -> Double.parseDouble(x[2])).sum();
		rows4.close();
		System.out.println(sumDouble);
		System.out.println();
		
		//Reduction - sum
		double total = Stream.of(7.3, 1.5, 4.8).reduce(0.0, (Double a, Double b) -> a + b);
		System.out.println(total);
		System.out.println();
		
		//Reduction summaryStatistics
		IntSummaryStatistics summaryStatistics = IntStream.of(1,2,3,4,5,6,7,8,9).summaryStatistics();
		System.out.println(summaryStatistics);
		System.out.println();
		
		//Reading an XML file
		List<String> stringList = Files.lines(Paths.get("Rom.xml"))
				.filter(line -> line.contains("name") || line.contains("artifactId"))
				.map(line -> 
					line.trim().replaceAll("<", "")
					.replaceAll(">", "")
					.replaceAll("/", "")
					.replaceAll("name", "")
					.replaceAll("artifactId", ""))
				.collect(Collectors.toList());
		stringList.forEach(item -> System.out.println(item));
		System.out.println();
		
		//peeking using streams
		Stream.of(1, 2, 3, 4)
			.filter(item -> item != 1)
			.peek(item -> System.out.println(item))
			 .collect(Collectors.toList());
		System.out.println();
		
		//skipping using streams
		Stream.of(1, 2, 20, 4, 5, 8, 10, 11)
				.skip(3)
				.filter(item -> item > 5)
				.collect(Collectors.toList())
				.forEach(item -> System.out.println(item));
		
		
		
	}

}
