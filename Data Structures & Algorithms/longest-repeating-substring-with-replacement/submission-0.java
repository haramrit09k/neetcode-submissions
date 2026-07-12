class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int maxLen = 0; //length of longest substring with one distinct char
        int maxFreq = 0;
        int[] count = new int[26];
        while(r < s.length()){
            char current = s.charAt(r);
            count[current - 'A']++;
            maxFreq = Math.max(maxFreq, count[current - 'A']);

            while((r - l + 1) - maxFreq > k){
                count[s.charAt(l) - 'A']--;
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
