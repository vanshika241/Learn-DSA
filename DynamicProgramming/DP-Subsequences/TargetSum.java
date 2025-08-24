public class TargetSum {
    public  int findWays(int num[], int tar) {
        int n = num.length;
        int dp[][] = new int[n][tar+1];
        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }
        if(num[0] == 0){
            dp[0][0] = 2;

        }
        else{
           if(tar>=num[0]) dp[0][num[0]] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=tar;j++){
                int take = 0;
                if (j>=num[i]) {
                    take = dp[i-1][j-num[i]];
                }
                int nottake = dp[i-1][j];
                dp[i][j] = take+nottake;
            }
        }
        return dp[n-1][tar];
        
    }
    public int findTargetSumWays(int[] nums, int target) {
         int S = 0;
     for(int num:nums)S += num;

             if (S - target < 0 || (S - target) % 2 != 0) return 0;

     int tar = (S-target)/2;
     return findWays(nums, tar);
    }
}

