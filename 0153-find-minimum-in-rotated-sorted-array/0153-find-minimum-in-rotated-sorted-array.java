class Solution {
    public int findMin(int[] nums) {
        int l = 0,r=nums.length-1;
        int ans = Integer.MAX_VALUE;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[l]<=nums[mid]){
                ans=Math.min(ans,nums[l]);
                l=mid+1;
            }else{// mid+1 to r
            ans = Math.min(ans, nums[mid+1]);
            r = mid;
            }
        } 
        return ans;
    }
}