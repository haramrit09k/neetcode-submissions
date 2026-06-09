class Solution {
    public boolean isAnagram(String s, String t) {

        // early exit
        if(s.length() != t.length()) return false;

        Map<Character, Integer> s_map = new HashMap<Character, Integer>();
        Map<Character, Integer> t_map = new HashMap<Character, Integer>();

        for(char cs: s.toCharArray()){
            s_map.put(cs, s_map.getOrDefault(cs, 0) + 1);
        }

        for(char ct: t.toCharArray()){
            t_map.put(ct, t_map.getOrDefault(ct, 0) + 1);
        }

        return s_map.equals(t_map);

    }
}
