// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long m = Long.parseLong(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());
            long a[] = new long[(int)(n)];
            long b[] = new long[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(inputLine1[i]);
            }
            
            
            Compute obj = new Compute();
            pair [] answer = obj.allPairs( a, b, n, m, k);
            int sz = answer.length;
            
            if(sz==0)
            System.out.println(-1);
            else{
                StringBuilder output = new StringBuilder();
                for(int i=0;i<sz;i++){
                    if(i<sz-1)
                    output.append(answer[i].first +" "+ answer[i].second + ", ");
                    else
                    output.append(answer[i].first +" "+ answer[i].second);
                    
                }
                System.out.println(output);
            }
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Compute {
    public pair[] allPairs( long a[], long b[], long n, long m, long k) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0;
        int j = b.length-1;
        ArrayList<pair> ans = new ArrayList<pair>();
        while (i < a.length && j >= 0) {
            long x = a[i];
            long y = b[j];
            if ((x + y) == k) {
                pair curr = new pair(x, y);
                ans.add(curr);
                i++;
            }
            else if ((x + y) > k)
                j--;
            else
                i++;
        }
        
        int len = ans.size();
        pair [] pairAns = new pair [len];
        int h = 0;
        for (pair p : ans) {
            pairAns[h] = p;
            h++;
        }
        return pairAns;
    }
}