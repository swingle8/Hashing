// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}// } Driver Code Ends



class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int size = 0;
        for (int i = 0 ; i < n ; i++) {
            if (map.containsKey(A[i]))
                map.put(A[i], map.get(A[i])+1);
            else
                map.put(A[i], 1);
            size++;
            if (size%k == 0) {
                size--;
                ans.add(map.size());
                int remove = A[i+1-k];
                int count = map.get(remove);
                if (count > 1)
                    map.put(remove, count-1);
                else
                    map.remove(remove);
            }
        }
        return ans;
    }
}

