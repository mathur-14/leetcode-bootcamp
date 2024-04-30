class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i = 0; i < coins.length; i++)
            Arrays.fill(dp[i], -1);
        int res = coins(coins.length-1, coins, amount, dp);
        if(res == (int) 1e9) 
            return -1;
        return res;
    }

    int coins(int n, int[] coins, int amount, int[][] dp) {
        if(n == 0) {
            if(amount % coins[0] == 0) 
                return amount/coins[0];
            else 
                return (int) 1e9;
        }
        if(dp[n][amount] != -1) 
            return dp[n][amount];
        int notPick = 0 + coins(n-1, coins, amount, dp);
        int pick = Integer.MAX_VALUE;
        if(coins[n] <= amount) 
            pick = 1 + coins(n, coins, amount - coins[n], dp);
        return dp[n][amount] = Math.min(pick, notPick);
    }
}