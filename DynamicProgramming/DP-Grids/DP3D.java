
public class DP3D {
    public static int memoAns(int i, int j1, int j2 ,int[][] grid,int r, int c,  int dp[][][]){
        if (j1<0 || j1>=c || j2<0 || j2>=c) {
            return Integer.MIN_VALUE;
        }
        
        if (i == r-1) {
            if(j1 == j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1] + grid[i][j2];
            }
        }

        if(dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }

        int maxi = Integer.MIN_VALUE;
        for(int dj1=-1 ;dj1<=1;dj1++){
             for(int dj2 =-1 ;dj2<=1;dj2++){
            int value = 0;
            if (j1 == j2) {
                value = grid[i][j1];
            }
            else{
                value = grid[i][j1] + grid[i][j2];
            }
            value += memoAns(i+1, j1+dj1, j2+dj2, grid, r, c,dp);
            maxi= Math.max(maxi, value);
        }
        
        }
        return dp[i][j1][j2]  = maxi;

    }
    public static int maximumChocolates(int r, int c, int[][] grid) {
      //return memoAns(0, 0, c-1, grid, r, c);
      int dp[][][] = new int[r][c][c];
      for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            for(int k=0;k<c;k++){
                dp[i][j][k] = -1;
            }
        }
      }

      return memoAns(c, c, c, grid, r, c, dp);
	}

    public static int tabuAns(int r, int c, int[][] grid) {
    int[][][] dp = new int[r][c][c];

    // Base case: last row
    for (int j1 = 0; j1 < c; j1++) {
        for (int j2 = 0; j2 < c; j2++) {
            if (j1 == j2) dp[r - 1][j1][j2] = grid[r - 1][j1];
            else dp[r - 1][j1][j2] = grid[r - 1][j1] + grid[r - 1][j2];
        }
    }

    // Bottom-up filling
    for (int i = r - 2; i >= 0; i--) {
        for (int j1 = 0; j1 < c; j1++) {
            for (int j2 = 0; j2 < c; j2++) {
                int maxi = Integer.MIN_VALUE;

                // Move combinations for both robots
                for (int dj1 = -1; dj1 <= 1; dj1++) {
                    for (int dj2 = -1; dj2 <= 1; dj2++) {
                        int value = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];

                        int newJ1 = j1 + dj1;
                        int newJ2 = j2 + dj2;

                        if (newJ1 >= 0 && newJ1 < c && newJ2 >= 0 && newJ2 < c) {
                            value += dp[i + 1][newJ1][newJ2];
                        } else {
                            value += (int) -1e9; // invalid move
                        }

                        maxi = Math.max(maxi, value);
                    }
                }

                dp[i][j1][j2] = maxi;
            }
        }
    }

    return dp[0][0][c - 1];
}

}
