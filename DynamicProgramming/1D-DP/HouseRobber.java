public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];
        for(int i=1;i<n;i++){
            int take = nums[i] + dp[i-1];
            int notTake = Integer.MIN_VALUE;
            if(i-2>=0)notTake = dp[i-2];
            dp[i] = Math.max(take, notTake);
        }
        return dp[n];
    }
    public static void main(String[] args) {
        
    }
}
