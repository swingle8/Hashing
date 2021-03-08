// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    int arr[]=new int[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextInt();
		    }

		    System.out.println(findSubarray(arr,n));
		}
		
	}

 // } Driver Code Ends
//User function Template for Java

public static int findSubarray(int[] arr ,int n) 
{
    //int sum = 0;
    
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
    int sumArray = arr[0];
    
    map.put(sumArray, new ArrayList<Integer>());
    map.get(sumArray).add(0);
    
    int ans = 0;
    
    for (int i = 1 ; i < n ; i ++) {
        sumArray = sumArray + arr[i];
        if (! map.containsKey(sumArray)) 
            map.put(sumArray, new ArrayList<Integer>());
        
        map.get(sumArray).add(i);
    }
    
    for (int key : map.keySet()) {
        int size = map.get(key).size();
        
        if (key == 0)
           ans = ans + (size * (size+1))/2;
        else
            ans = ans + ((size-1) * (size))/2;
        
        //System.out.println(key + " :  " + size + " : " + ans);
    }


    
    
    return ans;
}
    



// { Driver Code Starts.


}
  // } Driver Code Ends