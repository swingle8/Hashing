// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        
        int n = arr.length;
 
        for (int i = 0 ; i <= n-4 ; i++) {
            int w = arr[i];
            for (int j = i+1; j <= n-3 ; j ++) {
                int x = arr[j];
                int start = j+1;
                int end = n-1;
                while (start < end) {
                    int y = arr[start];
                    int z = arr[end];
                    int sum = w + x + y + z;
                    if (sum > k)
                        end--;
                    else if (sum < k)
                        start++;
                    else {
                        ArrayList<Integer> subSet = new ArrayList<Integer>();
                        subSet.add(w);
                        subSet.add(x);
                        subSet.add(y);
                        subSet.add(z);
                        
                        if (! ans.contains(subSet)) {
                            ans.add(subSet);
                        }
                        end--;
                    }
                    
                }
            }
        }
        
        return ans;
    }
}