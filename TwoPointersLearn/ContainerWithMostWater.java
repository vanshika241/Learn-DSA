public class ContainerWithMostWater {
    public int maxArea(int[] height) {
      int maxi = 0;
      int n = height.length;
    //   for(int i=0;i<n;i++){
    //     for(int j=i+1;j<n;j++){ // for min i have to check every time 
    //        int minH = Math.min(height[i], height[j]);
    //        int width = j-i;
    //        maxi = Math.max(maxi, minH*width);
    //     }
    //   }

      //T.C = O(N^2) - to reduce it we use Two ponters - because i can track min and max height easily 
      int left = 0;
      int right = n-1;
      while (left<right) {
        int minH = Math.min(height[left], height[right]);
        int width = right-left;
        maxi = Math.max(maxi, minH*width);
        if (height[left]>height[right]) {
            right--;
        }
        else{
            left++;
        }
      }

      return maxi;
    }
}
