class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int start = 0;
        
        for(int i = 0; i < s.length(); i++){
            int odd = expand(i, i, s);
            int even = expand(i, i+1, s);

            int len = Math.max(odd, even);

            if(len > maxLen){
                maxLen = len;
                start = i - (len - 1)/2;
            }
        }

        return s.substring(start, start+maxLen);
    }

    private static int expand(int l, int r, String s){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return (r - 1) - (l + 1) + 1; // since l and r overshoot the palindrome boundaries by 1 each when loop finishes - amounts to (r - l - 1)
    }
}
