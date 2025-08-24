
public class PartitionEqual {
     public boolean isSubsetSum(int n , int arr[], int target){
        boolean dp[][] = new boolean[n][target+1];
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
       if(target >= arr[0]) dp[0][arr[0]] = true;
        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                boolean nottake = dp[i-1][j];
                boolean take = false;
              if(j >= arr[i])  take = dp[i-1][j-arr[i]];
              dp[i][j] = take || nottake;
            }
        }
        return dp[n-1][target];

    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int num:nums)totalSum += num;
        if (totalSum %2 != 0) {
            return false;
        }
        return isSubsetSum(n,nums, totalSum/2);
    }
}
