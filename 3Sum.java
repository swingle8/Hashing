// 15. 3Sum
// Medium

// 7935

// 873

// Add to List

// Share
// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// Notice that the solution set must not contain duplicate triplets.

 

// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Example 2:

// Input: nums = []
// Output: []
// Example 3:

// Input: nums = [0]
// Output: []
 

// Constraints:

// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
// Accepted
// 1,028,148
// Submissions
// 3,797,040



class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> al = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Set<List<Integer>> refined  = new HashSet<List<Integer>>();
        for (int i = 0 ; i < nums.length-2 ; i++) {
            int sum = nums[i];
            map = new HashMap<Integer, Integer>();
            int target = 0 - sum;
            for (int j = i+1 ; j < nums.length ; j++) {
                if (map.containsKey(target - nums[j])) {
                    al = new ArrayList<Integer>();
                    al.add(nums[i]);
                    al.add(target - nums[j]);
                    al.add(nums[j]);
                    Collections.sort(al);
                    refined.add(al);
                }
                else {
                    map.put(nums[j], 0);
                }
            }
        }
        
        for (List<Integer> subset : refined) {
            ans.add(subset);
       }
        return ans;
    }
}