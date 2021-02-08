import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int cases = sc.nextInt();
	    while (cases -- > 0) {
	        int n = sc.nextInt();
	        int [] arr = new int[n];
	        for (int i = 0 ; i < n ; i ++)
	            arr[i] = sc.nextInt();
	       
	        SortingBasedOnFrequency (arr, n);
	    }
	}
	
	public static void SortingBasedOnFrequency (int [] arr, int n) {
	    Arrays.sort(arr);
	    int len = arr.length;
	    int [][] countArr = new int[len][2];
	    int l = 0;
	    int iterator = 0;
	    while (l < len) {
	        int count = 0;
	        int num = arr[l];
	        int j = l;
	        for ( ; j < len ; j++) {
	            if (num == arr[j])
	                count++;
	            else
	                break;
	        }
	        countArr[iterator][0] = num;
	        countArr[iterator][1] = count;
	        l = j;
	        iterator++;
	        
	    }
	    
	    
	    
	    
	    Arrays.sort(countArr, new Comparator<int []>() {
	        public int compare (final int [] a, final int [] b) {
                if (a[1] > b[1])
                    return -1;
                else
                    return 1;
	        }
	    });
	    
	    
	    for (int i = 0 ; i < len ; i++) {
	        int times = countArr[i][1];
	        while (times > 0) {
	            System.out.print(countArr[i][0] + " ");
	            times--;
	        }
	    }
	    System.out.println();
	}
}