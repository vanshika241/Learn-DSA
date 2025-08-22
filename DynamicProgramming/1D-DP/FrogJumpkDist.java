public class FrogJumpkDist {
    public static int minimizeCost(int n, int k, int []height){
        int dp[] = new int[n];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            int mini = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                   int  step = dp[i-j] + Math.abs(height[i]-height[i-j]);
                mini = Math.min(mini, step);
                }
            }
            dp[i] = mini;

        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        
    }
}
