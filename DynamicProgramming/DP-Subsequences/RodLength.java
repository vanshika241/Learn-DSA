public class RodLength {
    	public static int cutRod(int price[], int n) {
		int size = price.length;
          int dp[][]  = new int[size+1][n+1];
          for(int i=1;i<size+1;i++){
            for(int j=1;j<n+1;j++){
                int take = 0;
               if(i<=j) take = price[i-1]+dp[i][j-i];
               int nottake = dp[i-1][j];
               dp[i][j] = Math.max(nottake, take);
            }
          }
          return dp[size][n];

    
	}
}
