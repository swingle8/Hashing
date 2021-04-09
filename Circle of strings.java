// { Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine().trim());
		while(t-->0){
		    String A[] = in.readLine().trim().split(" ");
		    int N = Integer.parseInt(A[0]);
		    A = in.readLine().trim().split(" ");
		    
		    Solution ob = new Solution();
		    System.out.println(ob.isCircle(N, A));
		}
    }
}// } Driver Code Ends


// User function Template for Java
class Solution
{
    static int isCircle(int N, String A[])
    {
        int [] count = new int[26];
        for (int i = 0 ; i < A.length ; i++) {
            String curr = A[i];
            int len = curr.length();
            char [] characters = curr.toCharArray();
            count[characters[0]-'a']++;
            count[characters[len-1]-'a']++;
        }
        
        for (int i = 0 ; i < 26 ; i++) {
            if (count[i] > 0 && count[i]%2 != 0)
                return 0;
        }
        
        return 1;
    }
}