package codingProblems;

//find the square root of a number without using the square root method inbuilt.


public class Mahindra1 {

	public static void main(String[] args) {
		
	    double rootValue = 10;
	    double num = 10;
	     
	    for (int i = 0; i <4; i++) {
	         
	        rootValue = (num/rootValue + rootValue)/2;
	    }   
	     
	    //To make only 3 digit available after decimal point
	    int returnValue = (int)(rootValue * 100000);  
	    rootValue = returnValue;
	    rootValue /=100000;
	     
	    System.out.println("Root Value Calculated : " + rootValue);
	    System.out.println("Root Value By InBuild Method Method : " + Math.sqrt(10));
	}
	
}
