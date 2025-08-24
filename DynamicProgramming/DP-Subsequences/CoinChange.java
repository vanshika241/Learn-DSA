public class CoinChange {
    public int change(int amount, int[] coins) {
int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i=0;i<n;i++)dp[i][0] = 1;
        for(int j=0;j<=amount;j++){
            if(j%coins[0] == 0)dp[0][j] = 1;
        }
        if(amount>coins[0])dp[0][coins[0]] = 1;
        for(int i=1;i<n;i++){
            for(int j=1;j<=amount;j++){
                int take = 0;
                if (j>=coins[i]) {
                    take = dp[i][j-coins[i]];
                }
                int nottake = dp[i-1][j];
                dp[i][j] = take+nottake;
            }
        }
return dp[n-1][amount];  
  }
}
