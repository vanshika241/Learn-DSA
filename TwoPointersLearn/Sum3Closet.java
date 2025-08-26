import java.util.Arrays;

public class Sum3Closet {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int closetSum = nums[0]+nums[1]+nums[2];
        for(int i=0;i<n;i++){
            int j=i+1;
            int k = n-1;
            while (j<k) {
              int currSum = nums[i]+nums[j]+nums[k];
              if (Math.abs(closetSum-target)> Math.abs(currSum-target)) {
                closetSum = currSum;
              }
              if (currSum<target) {
                j++;
              }
              else{
                k--;
              }
            }
        }
        return closetSum;
        
    }
}
