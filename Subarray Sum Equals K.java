// Subarray Sum Equals K
// Medium

// 5491

// 176

// Add to List

// Share
// Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

// Example 1:

// Input:nums = [1,1,1], k = 2
// Output: 2
 

// Constraints:

// The length of the array is in range [1, 20,000].
// The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].


class Solution {
    public int subarraySum(int[] nums, int k) {
        int pSum = 0;
        int ans = 0;
        HashMap<Integer, Integer> preSum = new HashMap<Integer, Integer>();
        preSum.put(0,1);
        for (int i = 0 ; i < nums.length ; i++) {
            pSum = pSum + nums[i];
            int diff = pSum - k;
            if (preSum.containsKey(diff)) {
                ans = ans + preSum.get(diff);
            }
            preSum.put(pSum, preSum.getOrDefault(pSum, 0)+1);
        }
        return ans;
    }
}