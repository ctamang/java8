package codingProblems;

import java.util.Scanner;
import java.util.Stack;

//We can move in 4 directions from a given cell(i,j), i.e. we can move to (i+1,j) or (i,j+1) or (i-1, j) or(i, j-1)  with the condition
// that the adjacent cells have a difference of 1. write a code to find the longest path which can be traversed.
/*
Example : 
	
	input : mat[][] = {
					   {1,2,9},
					   {5,3,8},
					   {4,6,7}
					  }

output:4
the longest path is : 6-7-8-9*/

public class Mahindra2 {

	public static void main(String[] args) {
		
		  
	       Scanner sc=new Scanner(System.in);
	       System.out.println("enter rows:");
	       int rows=sc.nextInt();
	       System.out.println("enter columns");
	       int columns=sc.nextInt();
	       System.out.println("Enter array elements : ");    
	       int twoD[][]=new int[rows][columns];
	          
	        for(int i=0; i<rows;i++)
	         {            
	            for(int j=0; j<columns;j++)
	            {
	                twoD[i][j]=sc.nextInt();
	            }
	         }
	        
	        findLongestPath(twoD, rows, columns);
	        sc.close();
	}

	private static void findLongestPath(int[][] twoD, int rows, int columns) {
		
		Stack<Integer> longestPath = new Stack<Integer>();
		for(int i=0; i<rows;i++)
        {            
           for(int j=0; j<columns;j++)
           {
               int node = twoD[i][j];
				if (i != 0) {
					int k = twoD[i-1][j];
					if (node - k == 1 || node - k == -1) {
						longestPath.push(k);
					}
					if(j!=0) {
						k= twoD[i+1][j-1];
						if (node - k == 1 || node - k == -1) {
							longestPath.push(k);
						}
					}
				}
				if(i < rows - 1) {
					int k= twoD[i+1][j];
					if (node - k == 1 || node - k == -1) {
						longestPath.push(k);
					}
					k= twoD[i][j+1];
					if (node - k == 1 || node - k == -1) {
						longestPath.push(k);
					}
				}
				if(j < columns - 1) {
					int k= twoD[i][j+1];
					if (node - k == 1 || node - k == -1) {
						longestPath.push(k);
					}
					k= twoD[i+1][j];
					if (node - k == 1 || node - k == -1) {
						longestPath.push(k);
					}
				}
				if(j != 0) {
					int k= twoD[i][j-1];
					if (node - k == 1 || node - k == -1) {
						longestPath.push(k);
					}
					if(i != 0) {
						k= twoD[i-1][j+1];
						if (node - k == 1 || node - k == -1) {
							longestPath.push(k);
						}
					}
				}
           }
        }
			
	}

	
}
