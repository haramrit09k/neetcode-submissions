class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        String s1Sorted = new String(c1);

        for(int i = 0; i <= s2.length()-s1.length(); i++){
            String s2Sub = s2.substring(i, i+s1.length());
            char[] c2Sub = s2Sub.toCharArray();
            Arrays.sort(c2Sub);
            String s2SubSorted = new String(c2Sub);
            if(s2SubSorted.equals(s1Sorted)) return true;
        }

        return false;
    }
}
