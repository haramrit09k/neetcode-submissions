class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] countS1 = new int[26];
        for(char c: s1.toCharArray()){
            countS1[c-'a']++;
        }

        int l = 0, r = s1.length();
        while(r <= s2.length()){
            int countS2Sub[] = new int[26];
            char[] ch2Sub = s2.substring(l, r).toCharArray();
            for(char c: ch2Sub){
                countS2Sub[c-'a']++;
            }
            if(Arrays.equals(countS2Sub, countS1)) return true;

            l++;
            r++;
        }

        return false;
    }
}
