// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}// } Driver Code Ends




class Solution
{
    // return the smallest window in S with all the characters of P
    // if no such window exists, return "-1" 
    public static String smallestWindow(String s, String p){
        int len = p.length();
        int [] charCount = new int[26];
        int [] strcharCount = new int[26];
        
        for (int i =  0 ; i < p.length() ; i++) {
            char curr = p.charAt(i);
            charCount[curr-'a']++;
        }
        
        int min = Integer.MAX_VALUE;
        int count = 0;
        int start = 0 ;
        int end = 0;
        String ans = null;
        while (end < s.length() && start < s.length()) {
            char ch = s.charAt(end);
            strcharCount[ch-'a']++;
            if (strcharCount[ch-'a'] <= charCount[ch-'a']) {
                count++;
            }
            if (count == p.length()) {
                
                
                while (start < end) {
                    if (strcharCount[s.charAt(start)-'a'] > charCount[s.charAt(start)-'a'] || charCount[s.charAt(start)-'a'] == 0) {
                        strcharCount[s.charAt(start)-'a']--;
                        start++;
                    }
                    else if (strcharCount[s.charAt(start)-'a'] == charCount[s.charAt(start)-'a']) {
                        break;
                    }
                }
                int currLen = end-start+1;
                if (currLen < min) {
                    min = currLen;
                    ans = s.substring(start, end+1);
                }
            }
            end++;
        }
        
        if (ans == null)
            return "-1";
        return ans;
}
}