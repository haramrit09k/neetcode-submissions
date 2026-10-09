class Solution {
    public int countSubstrings(String s) {
        int total = 0;

        for(int i = 0; i < s.length(); i++){
            int odd = expand(i, i, s);
            int even = expand(i, i+1, s);

            total += odd + even;
        }

        return total;
    }

    private static int expand(int l, int r, String s){
        int count = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            count++;
            l--;
            r++;
        }

        return count;
    }
}
