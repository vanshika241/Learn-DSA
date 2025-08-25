public class ValidPalindrome {
     public boolean isPalindrome(String s) {
        s = s.toLowerCase().trim();
        int n = s.length();
        if (n == 0) {
            return true;
        }
        int left = 0;
        int right = n-1;
        while (left<right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
     }
}
