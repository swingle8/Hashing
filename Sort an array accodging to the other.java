// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.HashMap; 
import java.util.Map; 
import java.util.Map.Entry; 


class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    int a1[]=new int[n];
		    int a2[]=new int[m];
		    
		    for(int i=0;i<n;i++)
		    a1[i]=sc.nextInt();
		    
		    for(int i=0;i<m;i++)
		    a2[i]=sc.nextInt();
		    sortA1ByA2(a1,n,a2,m);
		    for(int x:a1)
		    System.out.print(x+" ");
		    
		    System.out.println();
		}
	}
	


 // } Driver Code Ends


//User function Template for Java

// A1[] : the input array-1
// N : size of the array A1[]
// A2[] : the input array-2
// M : size of the array A2[]
public static void sortA1ByA2(int A1[], int N, int A2[], int M)
{
    TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    for (int i = 0 ; i < N ; i++) {
        if (! map.containsKey(A1[i]))
            map.put(A1[i], 0);
        map.put (A1[i], map.get(A1[i]) + 1);
    }
    
    int j = 0;
    for (int i = 0 ; i < M ; i++) {
        int key = A2[i];
        if (map.containsKey(key)) {
            int chances = map.get(key);
            while (chances > 0) {
                A1[j] = key;
                j++;
                chances--;
            }
            map.remove(key);
        }
    }
    
    for (int key : map.keySet()) {
        int chances = map.get(key);
            while (chances > 0) {
                A1[j] = key;
                j++;
                chances--;
            }
    }
}



// { Driver Code Starts.

}


  // } Driver Code Ends