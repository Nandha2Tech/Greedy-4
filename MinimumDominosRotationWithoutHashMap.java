// Time Complexity : O(2n) -> O(n) -> n is the lenght of tops or bottoms
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


public class MinimumDominosRotationWithoutHashMap {
    public int minDominoRotations(int[] tops, int[] bottoms) {

        int result = check(tops,bottoms,tops[0]);
        if(result!=-1) return result;
        return check(tops,bottoms,bottoms[0]);
    }

    private int check(int[] tops, int[] bottoms, int target){

        int topR=0, bottomR=0;

        for(int i=0; i<tops.length; i++){
            if(tops[i] != target && bottoms[i] != target) return -1;
            if(tops[i] != target)topR++;
            if(bottoms[i] != target) bottomR++;
        }

        int result = Math.min(topR,bottomR);
        return result;
    }
}
