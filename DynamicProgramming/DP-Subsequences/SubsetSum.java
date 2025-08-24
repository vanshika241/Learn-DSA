
public class SubsetSum {
    public boolean recAns(int idx , int n , int arr[], int target){
        if (target == 0) {
            return true;
        }
        if (idx ==0 && arr[0] == target) {
            return true;
        }
        boolean nottake = recAns(idx-1, n, arr, target);
        boolean take = false;
        if(target>=arr[idx])take = recAns(idx-1, n, arr, target-arr[idx]);
        return take || nottake;

    }

    public boolean memoAns(int idx , int n , int arr[], int target, Boolean dp[][]){
        if (target == 0) {
            return true;
        }
        if (idx ==0 && arr[0] == target) {
            return true;
        }
        if (dp[idx][target] != null) {
            return dp[idx][target];
        }
        boolean nottake = memoAns(idx-1, n, arr, target, dp);
        boolean take = false;
        if(target >= arr[idx])take = memoAns(idx-1, n, arr, target-arr[idx], dp);
        return dp[idx][target] = take || nottake;
    }

    public boolean tabuAns(int n , int arr[], int target){
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

    public boolean isSubsetSum(int n, int arr[], int target){
        Boolean dp[][] = new Boolean[n][target+1];
        return memoAns(n-1, n, arr, target, dp);

    }
}
