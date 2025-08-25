import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ThreeSumProb {
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
          //Brute
        //   HashSet<List<Integer>> s = new HashSet<>();
        //   for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         for(int k=j+1;k<n;k++){
        //             if(nums[i]+nums[j]+nums[k] == 0){
        //                 List<Integer> curr = Arrays.asList(nums[i],nums[j],nums[k]); //store 
        //                 Collections.sort(curr); // use to sort the list 
        //                 s.add(curr); // store so that no duplicates ans come again
        //             }
        //         }
        //     }
        //   }
        //   List<List<Integer>> ans = new ArrayList<>(s);
        //   T.C = O(N^3)
        //   S.C = O(N)

        // HashSet<List<Integer>> s = new HashSet<>();
        // for(int i=0;i<n;i++){
        //     HashSet<Integer> set = new HashSet<>();
        //     for(int j=i+1;j<n;j++){
        //        int third = -(nums[i]+nums[j]);
        //        if (s.contains(third)) {
        //           List<Integer> curr = Arrays.asList(nums[i],nums[j],third);
        //           Collections.sort(curr);
        //           s.add(curr);
        //        }
        //        else{
        //         set.add(nums[j]);
        //        }
        //     }
        // }
        // List<List<Integer>> ans = new ArrayList<>(s);

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j=i+1;
            int k = n-1;
            while (j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                if (sum == 0) {
                    List<Integer> curr = Arrays.asList(nums[i],nums[j],nums[k]);
                    ans.add(curr);
                    j++;
                    k--;
                    while (j<k && nums[j] == nums[j-1]) {
                        j++;
                    }
                     while (j<k && nums[k] == nums[k+1]) {
                        k--;
                    }
                }
                else if (sum > 0) {
                    k--;
                }
                else{
                    j++;
                }
            }
        }
          return ans;
        }
}
