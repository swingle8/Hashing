//https://leetcode.com/problems/minimum-window-substring/
// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

// Example:

// Input: S = "ADOBECODEBANC", T = "ABC"
// Output: "BANC"
// Note:

// If there is no such window in S that covers all characters in T, return the empty string "".
// If there is such window, you are guaranteed that there will always be only one unique minimum window in S.



class Solution {
    public String minWindow(String s, String t) {
        String ans = "";
        int start = -1;
        int end = -1;
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (int i = 0 ; i < t.length() ; i++) {
            if (charMap.containsKey(t.charAt(i)))
                charMap.put(t.charAt(i), charMap.get(t.charAt(i))+1);
            else
                charMap.put(t.charAt(i), 1);
        }
        int counter = 0;
        String curr_ans = "";
        
        for (int i = 0 ; i < s.length() ; i++) {
            char curr = s.charAt(i);
            if (charMap.containsKey(curr)) {
                if (charMap.get(curr) > 0)
                    counter++;
                    
                int val = charMap.get(curr);
                val--;
                charMap.put(curr, val);
                end = i;
                curr_ans = curr_ans + curr;
                if (start == -1) {
                    start = i;
                    curr_ans = "" + curr;
                }
            }
            else if (counter < t.length()) {
                end = i;
                curr_ans = curr_ans + curr;
            }
           // System.out.println(counter);
          //  System.out.println(charMap.size());
            
            if (counter == t.length()) {
                while (counter >= t.length()-1 && start < s.length() && start >= 0) {
                    if (counter == t.length() && (curr_ans.length() < ans.length() || ans.length() == 0)) {
                        ans = curr_ans;
                    }
                    char startChar = s.charAt(start);
                    if (charMap.containsKey(startChar)) {
                        if (counter == t.length()-1)
                            break;
                        int currVal = charMap.get(startChar);
                        currVal++;
                        if (currVal > 0)
                            counter--;
                        charMap.put(startChar, currVal);
                    }
                    
                    if (start == end)
                        start = -1;
                    else
                        start++;
                    curr_ans = curr_ans.substring(1);
                    
                }
            }
            
        }
        return ans;
    }
}
