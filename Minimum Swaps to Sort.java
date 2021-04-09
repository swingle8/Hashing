// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends


class Solution
{
    public int minSwaps(int nums[])
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int [] sorted = new int [nums.length];
        for (int i = 0 ; i < nums.length ; i ++) {
            map.put(nums[i], i);
            sorted[i] = nums[i];
        }
        
        int count = 0;
        Arrays.sort(sorted);
        int swap = 0;
        for (int i = 0 ; i < nums.length; i ++) {
            int curr = nums[i];
            int sortedVal = sorted[i];
            if (curr == sortedVal)
                continue;

            int currIndex = i;
            int sortedIndex = map.get(sortedVal);
            
            swap (currIndex, sortedIndex, nums);
            map.put(curr, sortedIndex);
            map.put(sortedVal, currIndex);
            
            count++;
        }
        
        return count;
    }
    
    public void swap (int x, int y, int [] nums) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}


