public class HouseRobber2{

    public int tabuAns(int nums[]){
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];
        for(int i=1;i<n;i++){
            int take = nums[i];
            if(i-2>=0)take += dp[i-2];
            int notTake = dp[i-1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[n-1];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n ==0)return 0;
        if(n ==1)return nums[0];
        int nums1[] = new int[n-1];
        int nums2[] = new int[n-1];
        for(int i=0;i<n-1;i++){
            nums1[i] = nums[i];
        }
        for(int i=0;i<n-1;i++){
            nums2[i] = nums[i+1];
        }
        int ans1 = tabuAns(nums1);
        int ans2 = tabuAns(nums2);
        return Math.max(ans1, ans2);
    }
    public static void main(String[] args) {
        
    }
}