import java.util.*;
public class TriangularGridMinSum {
    public int memoAns(int i , int j , List<List<Integer>> triangle , int n , int dp[][] ){
        if (i == n-1 ) {
            return triangle.get(n-1).get(j);
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int d = triangle.get(i).get(j) + memoAns(i+1, j, triangle, n,dp);
        int dg = triangle.get(i).get(j) + memoAns(i+1, j+1, triangle, n,dp);
        return dp[i][j] = Math.min(d, dg);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n ==0)return 0;
        int dp[][] = new int[n][n];
        for(int j=0;j<n;j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                dp[i][j] = triangle.get(i).get(j) +  Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}
