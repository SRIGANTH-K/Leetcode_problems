class Solution {
    public int maximumProduct(int[] nums) {
        int min = 1000;
        int max = -1000;
        int sMax = max;
        int tMax = max;
        int sMin = min;
        for (int i =0;i<nums.length;i++){
            if (nums[i]>max){
                tMax = sMax;
                sMax = max;
                max = nums[i];
            }else if (nums [i]>sMax){
                tMax = sMax;
                sMax = nums[i];
            }else if (nums[i]>tMax){
                tMax = nums[i];
            }

            if (nums[i]<min){
                
                sMin = min;
                min = nums[i];
            }else if (nums[i]<sMin){                
                sMin = nums[i];
            }
        }
        int p1 = max*sMax*tMax;
        int p2 = min*sMin*max;
        return Math.max(p1,p2);
    }
}