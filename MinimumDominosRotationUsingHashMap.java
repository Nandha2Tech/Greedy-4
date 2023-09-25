
// Time Complexity : O(2n) -> O(n) -> n is the lenght of tops or bottoms
// Space Complexity : O(1)  // only 6 numbers in hashmap
// Did this code successfully run on Leetcode : Yes


//Using HashMap
import java.util.HashMap;

public class MinimumDominosRotationUsingHashMap {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int le = tops.length;
        int target = -1;
        for(int i=0; i<le; i++){

            map.put(tops[i],map.getOrDefault(tops[i],0)+1);
            if(map.get(tops[i]) == le)
            {
                target = tops[i];
                break;
            }

            map.put(bottoms[i],map.getOrDefault(bottoms[i],0)+1);
            if(map.get(bottoms[i]) == le)
            {
                target = bottoms[i];
                break;
            }
        }

        if(target == -1) return -1;

        int topR = 0, bottomR = 0;

        for(int i=0; i<le; i++){
            if(tops[i] != target && bottoms[i] != target) return -1;
            if(tops[i] != target) topR++;
            if(bottoms[i] != target) bottomR++;
        }
        return Math.min(topR,bottomR);
    }
}
