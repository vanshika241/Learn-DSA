
public class MinimizeSumPartition {
    public  static int isSubsetSum(int n , int arr[], int target){
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
         int mini = Integer.MAX_VALUE;
         for(int j=0;j<=target/2;j++){
            if(dp[n-1][j] == true)mini = Math.min(target-2*j, mini);
         }
        return mini;

    }
    public static int minSubsetSumDifference(int []arr, int n) {
       int totalSum = 0;
       for(int num:arr){
        totalSum += num;
       }
       return isSubsetSum(n, arr, totalSum);



    }
}
