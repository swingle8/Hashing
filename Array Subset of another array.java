import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int cases = sc.nextInt();
	    while (cases -- > 0) {
	        int m = sc.nextInt();
	        int n = sc.nextInt();
	        
	        int [] arr1 = new int[m];
	        int [] arr2 = new int[n];
	        
	        for (int i = 0 ; i < m ; i++)
	            arr1[i] = sc.nextInt();
	        
	        for (int i = 0 ; i < n ; i++)
	            arr2[i] = sc.nextInt();
	       
	       if (isSubSet(m, arr1, n, arr2))
	            System.out.println("Yes");
	       else
	            System.out.println("No");
	    }
	}
	
	public static boolean isSubSet (int m, int [] arr1, int n, int [] arr2) {
	    HashSet<Integer> set = new HashSet<Integer>();
	    for (int i = 0 ;  i < m ; i++)
	        set.add(arr1[i]);
	   
	    for (int i = 0 ; i < n ; i++) {
	        if (! set.contains(arr2[i]))
	            return false;
	    }
	    
	    return true;
	}
}