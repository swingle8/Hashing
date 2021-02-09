// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends


//User function Template for Java


class Solution
{
    long findSwapValues(long A[], int n, long  B[], int m)
    {
        HashSet<Long> set = new HashSet<Long>();
        long sumA = 0;
        long sumB = 0;
        for (int i = 0 ; i < n ; i ++)
            sumA = sumA + A[i];
        
        for (int i = 0 ; i < m ; i ++)
            sumB = sumB + B[i];
        
        long diff = 0;
        if (sumB > sumA)
            diff = sumB - sumA;
        else
            diff = sumA - sumB;
        
        if (diff % 2 != 0)
            return -1;
        
        long transfer = diff/2;
        if (sumA > sumB)
            return calculate (A, B, set, transfer);
        return calculate (B, A, set, transfer);
    }
    
    long calculate (long [] big, long [] small, HashSet<Long> set, long transfer) {
        for (int i = 0 ; i < small.length ; i++)
            set.add(small[i]);
        
        
        for (int i = 0 ; i < big.length ; i++) {
            long num = big[i] - transfer;
            //System.out.println(num);
            if (set.contains(num))
                return 1;
        }
        return -1;
    }
}



// { Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int m =Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a,n,b,m);
            System.out.println(ans);
        }
    }
}




  // } Driver Code Ends