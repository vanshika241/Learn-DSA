import java.util.Arrays;

public class ClimbingStairs{

    public int memoAns(int n, int dp[]){
        if(n<0)return 0;
        if (n==0) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = memoAns(n-1, dp)+memoAns(n-2, dp);
    }
    public int tabuAns(int n){
        int dp[] = new int[n+1];
        if (n==0) {
            return 0;
        }
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            int firstStep = dp[i-1];
            int secondStep = 0;
            if (i-2>=0) {
                secondStep = dp[i-2];
            }
            dp[i] = firstStep+secondStep;
        }
        return dp[n];
    }
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return memoAns(n, dp);
    }

    public static void main(String[] args) {
        
    }
}