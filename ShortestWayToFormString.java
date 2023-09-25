import java.util.HashSet;

// Time Complexity : O(m*n) -> m is the lenght of the source and n is the length of the target
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


public class ShortestWayToFormString {

    public int shortestWay(String source, String target) {

        int i=0, j=0;
        int count = 1;
        HashSet<Character> set = new HashSet<>();

        for(int k=0; k<source.length(); k++){
            set.add(source.charAt(k));
        }

        while(j < target.length()){
            if(!set.contains(target.charAt(j))) return -1;

            if(source.charAt(i) == target.charAt(j)){
                j++;
                if(j == target.length()) return count;
            }
            i++;
            if(i == source.length()){
                count++;
                i=0;
            }
        }

        return -1;
    }
}
