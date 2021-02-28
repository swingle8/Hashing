// { Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
import java.util.*;
import java.util.HashSet;

class Driverclass
{
    // Driver Code
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
		    
			
			System.out.println(new Solution().findLongestConseqSubseq(a, n));
		
		t--;
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{   
    // arr[] : the input array
    // N : size of the array arr[]
    
    // return the length of the longest subsequene of consecutive integers
	static int findLongestConseqSubseq(int arr[], int N)
	{
	   HashSet<Integer> set = new HashSet<Integer>();
	   int ans = 1;
	   int min = arr[0];
	   
	   for (int i = 0 ; i < arr.length ; i++) {
	        min = Math.min(arr[i], min);
	        set.add(arr[i]);
	   }
	   set.remove(min);

	   int localAns = 1;
	   while (! set.isEmpty()) {
	       min++;
	       
	       if (set.contains(min)) {
	           localAns++;
	           set.remove(min);
	       }
	       else {
	           ans = Math.max(ans, localAns);
	           localAns = 0;
	       }
	   }
	   
	   if (localAns > 0)
	        ans = Math.max(ans, localAns);
	   
	   return ans;
	   
	}
}