class Solution {
    // Brute force TC O(nlogn) where n is max(s1.len, s2.len)
    public boolean checkInclusion(String s1, String s2) {
        // early exit
        if(s1.length() > s2.length()) return false;
        // sort s1 - the one that has to be substring
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        String s1Sorted = new String(c1);

        for(int i = 0; i <= s2.length()-s1.length(); i++){
            // take substring of s2 and sort it
            String s2Sub = s2.substring(i, i+s1.length());
            char[] c2Sub = s2Sub.toCharArray();
            Arrays.sort(c2Sub);
            String s2SubSorted = new String(c2Sub);
            // compare sorted s1 and sorted s2 substring
            if(s2SubSorted.equals(s1Sorted)) return true;
        }

        return false;
    }
}
