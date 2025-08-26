public class CountAllTriplets {
    public int countTriplets(int[] arr, int target) {
        //Here the array is already sorted 
        int n = arr.length;
        int cnt = 0;
        for(int i=0;i<n;i++){
            int j=i+1;
            int k = n-1;
            while (j<k) {
                int sum = arr[i]+arr[j]+arr[k];
                if (sum == target) {
                    if (arr[j] == arr[k]) {
                        int len = k-j+1;
                        cnt += (len*(len-1))/2;
                        break;
                    }
                    else{
                        int leftCount = 1;
                        int rightCount = 1;
                        while (j+1<k && arr[j] == arr[j+1]) {
                            leftCount++;
                            j++;
                        }
                        while (k-1>j && arr[k] == arr[k-1]) {
                            rightCount++;
                            k--;
                        }
                        cnt += leftCount*rightCount;
                    }
                }
                else if (sum > target) {
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return cnt;
    }
}
