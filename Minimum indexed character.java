// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;


 // } Driver Code Ends


class Solution{

    public static int minIndexChar(String str, String pat){
       HashMap<Character, Integer> map = new HashMap<Character, Integer>();
       for (int i = 0 ; i < str.length() ; i++) {
           char currentChar = str.charAt(i);
           if (! map.containsKey(currentChar))
                map.put(currentChar, i);
       }
       
       int index = -1;
       for (int i = 0 ; i < pat.length() ; i++) {
           char curr = pat.charAt(i);
           if (map.containsKey(curr) && (index == -1 || index > map.get(curr)))
            index = map.get(curr);
       }
       
       return index;
    }
}

// { Driver Code Starts.

class GFG {
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
		    t--;
		    
		    String s1=sc.next();
		    String s2=sc.next();
		    
		    int res = new Solution().minIndexChar(s1, s2);
		    if (res != -1)
		        System.out.println(s1.charAt(res));
		    else
		        System.out.println("No character present");
		}
	}
}
  // } Driver Code Ends