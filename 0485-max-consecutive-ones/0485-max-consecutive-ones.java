class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curCount = 0;
        int maxCount = 0;
        for (int i:nums){
            if (i==1){
                curCount++;
                //maxCount = Math.max(maxCount,curCount);
            }
            else{
                curCount = 0;               
            }
            maxCount = Math.max(maxCount,curCount);
        }
        return maxCount;
    }
}