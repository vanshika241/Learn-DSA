import java.util.Arrays;

public class UniquePaths {
    public int recAns(int m, int n){
      if(n <0 || m<0)return 0;
      if(m ==0 && n ==0)return 1;
      int up = recAns(m-1, n);
      int down = recAns(m, n-1);
      return Math.max(up, down);
    }

    public int memoAns(int i , int j , int dp[][]){
        if (i < 0 || j<0 ) {
            return 0;
        }
        if( i==0 && j ==0 )return 1;
        if(dp[i][j] != -1)return dp[i][j];
        int up = memoAns(i-1, j, dp);
        int left = memoAns(i, j-1, dp);
        return dp[i][j] = up+left;
    }

    public int tabuAns(int m , int n){
          if(m == 0  && n == 0)return 0;
          if(m ==1 && n ==1)return 1;
          
        int dp[][] = new int[m][n];
        for(int i=1;i<m;i++)dp[i][0] = 1;
        for(int j=1;j<n;j++)dp[0][j] = 1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int up = dp[i-1][j];
                int left = dp[i][j-1];
                dp[i][j] = up+left;
            }
        }
        return dp[m-1][n-1];
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        return memoAns(m-1, n-1, dp);
    }


    public static void main(String[] args) {
        
    }
}
