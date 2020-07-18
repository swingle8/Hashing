https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Input:
The first line of input contains an element T denoting the number of test cases. Then T test cases follow. Each test case consists of 2 lines. The first line of each test case contains a number denoting the size of the array A. Then in the next line are space-separated values of the array A.

Output:
For each test case, the output will be the length of the largest subarray which has sum 0.

User Task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.

Expected Time Complexity: O(N*Log(N)).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 100
1 <= N <= 104
-1000 <= A[i] <= 1000, for each valid i

Example:
Input
1
8
15 -2 2 -8 1 7 10 23

Output
5

Explanation
Testcase 1: In the above test case the largest subarray with sum 0 will be -2 2 -8 1 7.

// { Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}// } Driver Code Ends

class GfG
{
    int maxLen(int arr[], int n)
    {
        //int n = arr.length;
        int [] sum = new int[n+1];
        sum[0] = 0;
        
        for (int i = 0 ; i < n ; i++) {
            sum[i+1] = sum[i] + arr[i];
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < n+1 ; i ++) {
            if (map.containsKey(sum[i])) {
             int diff = i - map.get(sum[i]);
             if (diff > ans)
                ans = diff;
            }
            else {
                map.put(sum[i], i);
            }
        }
        return ans;
    }
}