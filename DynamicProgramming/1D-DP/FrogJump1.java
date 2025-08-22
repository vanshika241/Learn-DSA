import java.util.Arrays;

public class FrogJump1 {
    public int memoAns(int height[], int dp[], int idx){
        if (idx<0) {
            return Integer.MAX_VALUE;
        }
        if (idx == 0) {
            return height[idx];
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int firstStep = memoAns(height, dp, idx-1) + Math.abs(height[idx]-height[idx-1]);
        int secondStep = Integer.MAX_VALUE;
        if(idx-2>=0) secondStep = memoAns(height, dp, idx-2) + + Math.abs(height[idx]-height[idx-2]);
        return dp[idx] = Math.min(firstStep, secondStep);


    }
    public int tabuAns(int height[]){
        int n = height.length;
        int dp[] = new int[n];
        dp[0] = 0;
        for(int i=1;i<n;i++){
        int firstStep =  dp[i-1]+ Math.abs(height[i]-height[i-1]);
        int secondStep = Integer.MAX_VALUE;
        if(i-2>=0) secondStep = dp[i-2] + + Math.abs(height[i]-height[i-2]);
         dp[i] = Math.min(firstStep, secondStep);

        }
        return dp[n-1];
    }
    int minCost(int[] height) {
        // code here
        int n = height.length;
        int dp[] = new  int[n];
        Arrays.fill(dp, -1);
        return memoAns(height, dp, n-1);
        
    }
    public static void main(String[] args) {
        
    }
}
