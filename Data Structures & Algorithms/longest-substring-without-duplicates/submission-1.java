class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = Integer.MIN_VALUE;
        if(s == null || s.isEmpty()){
            return 0;
        }
        char[] chars = s.toCharArray();
        List<Character> substr = new ArrayList<>();
        int count = 0;
        for(char c: chars){
            if(!substr.contains(c)){
                substr.add(c);
                count+=1;
            }
            else{
                substr = new ArrayList<>();
                count = 0;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
