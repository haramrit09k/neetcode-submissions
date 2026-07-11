class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0; 
        for(int i = 0; i < s.length(); i++){
            Set<Character> charSet = new HashSet<>();
            for(int j = i; j < s.length(); j++){
                if(!charSet.contains(s.charAt(j))){
                    charSet.add(s.charAt(j));
                }
                else{
                    break;
                }
            }
            res = Math.max(res, charSet.size());
        }
        return res;
    }
}
