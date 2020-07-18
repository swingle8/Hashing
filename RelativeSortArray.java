//https://leetcode.com/problems/relative-sort-array/submissions/
// Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

// Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.

 

// Example 1:

// Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
// Output: [2,2,2,1,4,3,3,9,6,7,19]
 

// Constraints:

// arr1.length, arr2.length <= 1000
// 0 <= arr1[i], arr2[i] <= 1000
// Each arr2[i] is distinct.
// Each arr2[i] is in arr1.



class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < arr1.length ; i++) {
            if (map.containsKey(arr1[i])) {
                int val = map.get(arr1[i]);
                val++;
                map.put(arr1[i], val);
            }
            else
                map.put(arr1[i], 1);
        }
        
        int index = 0;
        int [] ans = new int[arr1.length];
        for (int i = 0 ; i < arr2.length ; i++) {
            int key = arr2[i];
            if (map.containsKey(key)) {
                int val = map.get(key);
                map.remove(key);
                while (val > 0) {
                    ans[index] = key;
                    val--;
                    index++;
                }
            }
        }
        
        TreeMap<Integer, Integer> tm  = new TreeMap<Integer, Integer>();
        tm.putAll(map);
        
        for (int i : tm.keySet()) {
            int val = tm.get(i);
            while (val > 0) {
                    ans[index] = i;
                    val--;
                    index++;
                }
        }
        
        return ans;
    } 
}
