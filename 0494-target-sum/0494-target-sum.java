class Solution {
    public int countSubset (int[] arr, int sum, int n, int[][] dp){
        if (sum == 0 && n==0) return 1;
        if(n==0) return 0;
        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }
        if (arr[n-1] <= sum) {
            int take = countSubset(arr, sum - arr[n-1], n-1, dp);
            int notTake = countSubset(arr, sum, n-1, dp);
            return dp[n][sum] = take + notTake;
        } else {
            return dp[n][sum] = countSubset(arr, sum, n-1, dp);
        }
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int i=0;i<nums.length;i++){
            sum = sum + nums[i];
        }
        if (Math.abs(target) > sum || (sum + target) % 2 != 0) {
            return 0;
        }
        int targett = (sum + target) / 2;
        int[][] dp = new int[n+1][targett+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return countSubset(nums,targett,n, dp);
    }
}