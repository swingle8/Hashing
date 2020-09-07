class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int maxTillNow = nums[0];
        
        for (int i = 1 ; i < nums.length ; i ++) {
            maxTillNow = Math.max(nums[i], maxTillNow + nums[i]);
            max = Math.max(max, maxTillNow);
        }
        return max;
    }
}