package InterviewQuestions;
/*
 Links : 
 	https://www.javatpoint.com/java-collections-interview-questions
 	https://www.journaldev.com/1330/java-collections-interview-questions-and-answers
************** 
Questions : 
**************
1. how the hash collisions are resolved?
2. what is the contract b/w the equals and the hashCode method of the object class?
3. what is the update came for hashMap optimization for hashMap implementation?
4. What is the default size of load factor in hashing based collection?
5. What is the difference between Comparable and Comparator?
6. What is the difference between Collection and Collections?
7. explain the internal working of the hashMap.
8. What is the benefit of Generics in Collections Framework?
9. Why Collection doesn’t extend Cloneable and Serializable interfaces?
10. why ConcurrentHashMap is used?
11. What is difference between Enumeration and Iterator interface?
12. What is different between Iterator and ListIterator?
13. What do you understand by iterator fail-fast property?
	Iterator fail-fast property checks for any modification in the structure of the underlying collection everytime we try to get 
	the next element. If there are any modifications found, it throws ConcurrentModificationException. All the implementations of 
	Iterator in Collection classes are fail-fast by design except the concurrent collection classes like ConcurrentHashMap and 
	CopyOnWriteArrayList.
14. What is difference between fail-fast and fail-safe?
15. Can we use any class as Map key?
16. What are different Collection views provided by Map interface??
17. Which collection classes provide random access of it’s elements?
18. Which collection classes are thread-safe?
19. What are concurrent Collection Classes?
20. What is BlockingQueue?
21. What is Collections Class?
22. While passing a Collection as argument to a function, how can we make sure the function will not be able to modify it?
23. How can we create a synchronized collection from given collection?
24. 


 	  
 	  
 	  
 * 
 * 
 */


import java.util.Iterator;
import java.util.LinkedHashSet;

public class Collection1 {

	public static void main(String[] args) {
		
		Integer[] arr = {10,20,30,40};
		
		arr[5] = 20;
		
	}
}
