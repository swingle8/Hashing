// { Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new Solution().checkTriplet(arr, n);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}// } Driver Code Ends


//User function Template for Java



class Solution {
    boolean checkTriplet(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0 ; i< n ; i ++) {
            arr[i] = arr[i] * arr[i];
            if (! map.containsKey(arr[i]))
                map.put(arr[i], 1);
        }
        
        for (int i = 0; i < n ; i++) {
            for (int j = i+1 ; j < n ; j++) {
                int sum = arr[i] + arr[j];
                if (map.containsKey(sum))
                    return true;
            }
        }
        
        return false;
    }
}