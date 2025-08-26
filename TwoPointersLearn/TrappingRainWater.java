
public class TrappingRainWater{
    public int trap(int[] height) {
       int n = height.length;
       //Brute force - take 2 array to store every value lmax and rmax 
    //    int left[] = new int[n];
    //    int right[] = new int[n];
    //    left[0] = height[0];
    //    right[n-1] = height[n-1];
    //    for(int i=1;i<n;i++){
    //     left[i] = Math.max(left[i-1], height[i]);
    //    }
    //     for(int i=n-2;i>=0;i--){
    //     right[i] = Math.max(right[i+1], height[i]);
    //    }
    //    int totalWater = 0;
    //    for(int i=0;i<n;i++){
    //     totalWater += Math.min(left[i], right[i])-height[i];
    //    }
       //but here T.C = O(N) which is good but S.C = O(N) we have to remove the extra space here woth traverse we have to calculate it max and min in entire array 
       //so lets do two pointers method 
  int left = 0;
  int right = n-1;
  int lmax = 0;
  int rmax = 0;
  int totalWater = 0;
  while (left<right) {
    lmax = Math.max(lmax, height[left]);
    rmax = Math.max(rmax, height[right]);
    if (lmax>rmax) {
        totalWater += rmax-height[right];
        right--;
    }
    else{
        totalWater += lmax - height[left];
        left++;
    }
  }
       return totalWater;

    }
}