import java.util.Arrays;

public class MinimumCoins {
    public int recAns(int idx, int[] coins, int amount){
        if (amount == 0) {
            return 0;
        }
        if (idx == 0) {
            if(amount%coins[0] == 0){
                return amount / coins[0];
            }
            else{
                return Integer.MAX_VALUE;
            }
        }

        int nottake = recAns(idx-1, coins, amount);
        int take = Integer.MAX_VALUE;
        take = Math.min(1+recAns(idx, coins, amount-coins[idx]), recAns(idx-1, coins, amount));
        return Math.min(nottake, take);
    }

    public int memoAns(int idx, int[] coins, int amount, int dp[][]){
        if (amount == 0) {
            return 0;
        }
        if (idx == 0) {
            if(amount%coins[0] == 0){
                return amount / coins[0];
            }
            else{
                return Integer.MAX_VALUE;
            }
        }
        if (dp[idx][amount] != -1) {
            return dp[idx][amount];
        }

        int nottake = memoAns(idx-1, coins, amount,dp);
        int take = Integer.MAX_VALUE;
        take = Math.min(1+memoAns(idx, coins, amount-coins[idx],dp), memoAns(idx-1, coins, amount,dp));
        return dp[idx][amount] = Math.min(nottake, take);
    }

    public int tabuAns(int[] coins, int amount){
         int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0; 
        }
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE; 
        }
        for(int j=1;j<amount+1;j++){
            if (j % coins[0] == 0) {
                dp[1][j] = j / coins[0];
            }
            else{
                dp[1][j] = Integer.MAX_VALUE;
            }

        }
        for(int i=2;i<n+1;i++ ){
            for(int j=1;j<amount+1;j++){
                int nottake = dp[i-1][j];
                int take = Integer.MAX_VALUE;
                if(j>=coins[i-1] && dp[i][j - coins[i-1]] != Integer.MAX_VALUE)take = 1+dp[i][j-coins[i-1]];
                dp[i][j] = Math.min(nottake, take);
            }
        }
        return( dp[n][amount] != Integer.MAX_VALUE) ?  dp[n][amount] : -1;
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp, -1);
        }
        return memoAns(n-1, coins, amount, dp);
       // return recAns(coins.length-1, coins, amount);
    }
}
