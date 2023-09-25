// Time Complexity : O(nlogk) n is the length of the target and k is the average length of the occurences of a character
// Worst case O(n log m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ShortestWayToFormStringUsishIndex {
    public int shortestWay(String source, String target) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for(int i=0; i<source.length(); i++){
            char c = source.charAt(i);
            if(!map.containsKey(c))
            {
                map.put(c,new ArrayList<>());
            }
            map.get(c).add(i);
        }
        int j=0; int i=0; int count = 1;
        while(j < target.length())
        {
            char c = target.charAt(j);

            if(!map.containsKey(c)) return -1;

            List<Integer> le = map.get(target.charAt(j));

            int k = Collections.binarySearch(le, i);
            if(k<0) k = -k-1;
            if(k == le.size()){
                i = le.get(0);
                count++;
            }else{
                i = le.get(k);
                i++; j++;
            }
        }

        return count;
    }
}
