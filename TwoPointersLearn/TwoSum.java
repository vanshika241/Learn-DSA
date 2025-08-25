import java.util.HashMap;

public class TwoSum{
        public int[] twoSum(int[] numbers, int target) {
           //Brute T.C = O(n^2)
           int n = numbers.length;
        //    for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){ // el search - O(n) - get O(1) 
        //         int sum = numbers[i]+numbers[j];
        //         if (sum == target) {
        //             return new int[]{i+1,j+1};// 1 index based return 
        //         }
        //     }
        //    }
        //    

           //Better - HashMap - second el access - O(1)
           //problem - space 

        //    HashMap<Integer,Integer> mp = new HashMap<>();
        //    for(int i=0;i<n;i++){
        //     int second = target-numbers[i]; // loop hatt gya - O(n)-O(1)
        //     if (mp.containsKey(second)) {
        //         return new int[]{mp.get(second)+1 ,i+1};
        //     }
        //     else{
        //         mp.put(numbers[i], i);
        //     }
        //    }

        //Optimal  - Space remove + Access O(1) - If array is not sorted and i have to return index then i will not use pointer because for this array must be sorted so that i can have a pattern but then the index will change and my answer not right
        //Two Pointers give Array is sorted 
        //T.C = N and S.C = 1
        int p1 = 0;
        int p2 = n-1;
        while (p1<p2) {
            int sum = numbers[p1]+numbers[p2];
            if (sum == target) {
                return new int[]{p1+1,p2+1};
            }
            else if (sum > target) {
                p2--;// to reduce the sum so that i can reach exact target 
            }
            else{
                p1++; // to increase the sum so that i can reach exact target 
            }
        }
     return new int[]{-1,-1}; // if not found
        }
}