//https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/submissions/

class Solution {
    public boolean canArrange(int[] nums, int k) {
        if (nums.length%2 != 0)
            return false;
        int [] count = new int[k];
        for (int i = 0 ; i < nums.length ; i ++) {
            int rem = ((nums[i]%k)+k)%k;
            count[rem]++;
        }
        
       if (count[0]%2 != 0)
            return false;
        
        for (int i = 1 ; i < k ; i++) {
            int num = count[i];
            
            if (num != count[k-i])
                return false;
    
        }
        
        return true;
    }
}