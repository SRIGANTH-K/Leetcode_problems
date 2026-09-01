class Solution {
    public int coinCount (int[] coins, int amount, int n, int[][] dp){
        if (n==0) return Integer.MAX_VALUE-1;
        if (amount == 0) return 0;
        if (dp[n][amount] != -1){
            return dp[n][amount];
        }
        if (coins[n-1]<=amount){
            int take = 1 + coinCount(coins, amount - coins[n-1], n, dp);
            int notTake = coinCount(coins, amount, n-1, dp);
            dp[n][amount] = Math.min(take, notTake);
        }else{
            dp[n][amount] = coinCount(coins, amount, n-1, dp);
        }
            return dp[n][amount];
    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int k = coinCount(coins, amount, coins.length, dp);
        if (k==Integer.MAX_VALUE-1){
            return -1;
        }
        return k;
    }
}