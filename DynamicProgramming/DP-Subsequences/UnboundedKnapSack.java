public class UnboundedKnapSack {
    public static int unboundedKnapsack(int n, int maxWeight, int[] value, int[] weight) {
          int dp[][]  = new int[n+1][maxWeight+1];
          for(int i=1;i<n+1;i++){
            for(int j=1;j<maxWeight+1;j++){
                int take = 0;
               if(j>=weight[i-1]) take = value[i-1]+dp[i][j-weight[i-1]];
               int nottake = dp[i-1][j];
               dp[i][j] = Math.max(nottake, take);
            }
          }
          return dp[n][maxWeight];

    }
}
