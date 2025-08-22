import java.util.Arrays;

public class Fibonacci{
    public static long recursiveAns(int n ){
        if (n<=1) {
            return n;
        }
        return recursiveAns(n-1)+recursiveAns(n-2);
    }
    public static long memoAns(int n, long dp[]){
       if (n<=1) {
            return n;
          }
       if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] =  memoAns(n-1, dp)+memoAns(n-2, dp);
    }
    static long topDown(int n) {
         long dp[] = new long[n+1];
         Arrays.fill(dp, -1);
         return memoAns(n, dp);
            }

    static long bottomUp(int n) {
       long dp[] = new long[n+1];
       dp[0] = 0;
       dp[1] = 1;
       for(int i=2;i<=n;i++){
        dp[i] = dp[i-1] + dp[i-2];
       }
       return dp[n];
    }
    public static void main(String[] args) {
        
    }
}