class Solution {
    public int maxArea(int[] height) {
        int maxwater = Integer.MIN_VALUE;
        int i = 0, j=height.length-1;
        while (i<j){
            int tempwater = (j-i)*Math.min(height[i],height[j]);
            maxwater = Math.max(tempwater,maxwater);
            if (height[i]>height[j]) j--;
            else i++;

            
        }
        return maxwater;
    }
}