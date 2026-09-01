class Solution {
    public static boolean checkSubset(int[] nums, int n, int target, Boolean[][] dp){
        if (target==0) return true;
        if(n==0) return false;
        if(dp[n][target]!=null){
            return dp[n][target];
        }
        if(nums[n-1]<=target){
            boolean take = checkSubset(nums, n-1, target-nums[n-1], dp);
            boolean notTake = checkSubset(nums, n-1, target, dp);
            dp[n][target] = take || notTake;
        }else{
            dp[n][target] = checkSubset(nums, n-1, target, dp);
        }
        return dp[n][target];
    }
    public boolean canPartition(int[] nums) {
        int ans=0;
        int n = nums.length;
        for (int i=0;i<nums.length;i++){
            ans = ans + nums[i];
        }
        if (ans%2!=0){
            return false;
        }
        int target = ans/2;
        Boolean[][] dp = new Boolean[n+1][target+1];
        return checkSubset(nums, n, target, dp);
    }
}