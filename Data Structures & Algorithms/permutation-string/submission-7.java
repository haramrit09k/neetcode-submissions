class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] countS1 = new int[26];
        for(char c: s1.toCharArray()){
            countS1[c-'a']++;
        }
        int countS2Sub[] = new int[26];

        int l = 0, r = s1.length();
        for(int i = 0; i< r; i++){
            countS2Sub[s2.charAt(i)-'a']++;
        }
        while(r < s2.length()){
            if(Arrays.equals(countS2Sub, countS1)) return true;
            countS2Sub[s2.charAt(l)-'a']--;
            l++;
            countS2Sub[s2.charAt(r)-'a']++;
            r++;
        }

        return Arrays.equals(countS2Sub, countS1);
    }
}
