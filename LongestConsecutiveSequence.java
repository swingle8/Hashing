//https://leetcode.com/problems/longest-consecutive-sequence/submissions/
//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

//Your algorithm should run in O(n) complexity.

//Example:

//Input: [100, 4, 200, 1, 3, 2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.





class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> Aset = new HashSet<Integer>();
        for (int i = 0 ; i < nums.length ; i++) {
            Aset.add(nums[i]);
        }
        int ans = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            int num = nums[i];
            if (Aset.contains(num-1))
                continue;
            int cur_ans = 1;
            while (Aset.contains(num+1)) {
                cur_ans++;
                num++;
            }
            
            if (cur_ans > ans)
                ans = cur_ans;
        }
        return ans;
    } 
}