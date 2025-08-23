import java.util.Arrays;

public class MinFallingPathSum {

    public int memoAns(int[][] matrix ,int i, int j , int dp[][], int n){
        if (j<0 || j>=n) {
            return Integer.MAX_VALUE;
        }
        if (i == 0) {
            return matrix[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j] ;
        }
        int up = memoAns(matrix, i-1, j, dp,  n);
        int left = memoAns(matrix, i-1, j-1, dp,  n);
        int right = memoAns(matrix, i-1, j+1, dp, n);
        int curr = matrix[i][j];
        if(up != Integer.MAX_VALUE) up += curr;
        if(left != Integer.MAX_VALUE) left += curr;
        if(right != Integer.MAX_VALUE) right += curr;
        return dp[i][j] = Math.min(Math.min(up, left), right);
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        int mini = Integer.MAX_VALUE;

        for(int j=0;j<n;j++){
            mini = Math.min(mini, memoAns(matrix, n-1, j, dp, n));
        }
        return mini;
    }

    public int tabuAns(int[][] matrix){
       int n = matrix.length;
        int dp[][] = new int[n][n];
        for(int j=0;j<n;j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int up =  matrix[i][j]+dp[i-1][j];
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if(j-1>=0)left = dp[i-1][j-1];
                if(j+1<=n-1)right = dp[i-1][j+1];
                if(left !=Integer.MAX_VALUE )left += matrix[i][j];
                if(right !=Integer.MAX_VALUE )right += matrix[i][j];
                dp[i][j] = Math.min(left, Math.min(up, right));
            }
        }
        int mini = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            mini = Math.min(mini, dp[n-1][j]);
        }
        return mini;
    }


    public static void main(String[] args) {
        
    }
}
