//https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
//Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.



class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hset = new HashSet<Character>();
        int start = -1;
        int end = -1;
        int ans = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0 ; i < s.length() ; i ++) {
            char c = s.charAt(i);
            if (! hset.contains(c)) {
                end = i;
                hset.add(c);
                count++;
                if (start == -1)
                    start = i;
            }
            else {
                if (count > ans)
                    ans = count;
                count--;
                char curr = s.charAt(start);
                hset.remove(curr);
                start++;
                i--;
            }
        }
        if (count > ans)
            ans = count;
        
        return ans;
    }
}